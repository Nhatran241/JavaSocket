package client;

import com.google.gson.Gson;
import javalibrary.SocketTransceiver;
import javalibrary.securedata.SecureDataManager;
import server.TcpServer;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public abstract class TcpClient implements Runnable {

	private int port;
	private String hostIP;
	private boolean connect = false;
	private SocketTransceiver transceiver;
	private boolean publicKeyServer;
	public void connect(String hostIP, int port) {
		this.hostIP = hostIP;
		this.port = port;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(hostIP, port);
			transceiver = new SocketTransceiver(socket) {
				@Override
				public void onReceive(InetAddress addr, byte[] data) {
					if(secretKey==null){
						try {
							/**
							 * Mã hóa Secretkey bằng Privatekey
							 */
							System.out.println("nhân Secretkey");
							byte[] decryptedKey = SecureDataManager.getInstance().DecrpytMessage(data, localKeyPair.getPrivate());
							secretKey = SecureDataManager.getInstance().createSecretKeyFromBytes(decryptedKey);
							onConnect(this);
						} catch (Exception e){
							e.printStackTrace();
						}

					}else {
						try {
							TcpClient.this.onReceive(transceiver,new String(data, "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}

				@Override
				public void onDisconnect(InetAddress addr) {
					disconnect();
					connect = false;
					TcpClient.this.onDisconnect(this);
				}

				@Override
				public void onThreadStartSuccess() {
					this.localKeyPair= SecureDataManager.getInstance().getKeyPair();
					connect = true;
					if(secretKey==null){
						this.send(localKeyPair.getPublic().getEncoded());
					}else TcpClient.this.onConnect(this);
				}
			};
			transceiver.start();
		} catch (Exception e) {
			e.printStackTrace();
			this.onConnectFailed();
		}
	}

	public void disconnect() {
		if (transceiver != null) {
			transceiver.stop();
			transceiver = null;
		}
	}


	public boolean isConnected() {
		return connect;
	}

	public SocketTransceiver getTransceiver() {
		return isConnected() ? transceiver : null;
	}

	public abstract void onConnect(SocketTransceiver transceiver);

	public abstract void onConnectFailed();

	public abstract void onReceive(SocketTransceiver transceiver,String message);

	public abstract void onDisconnect(SocketTransceiver transceiver);
}
