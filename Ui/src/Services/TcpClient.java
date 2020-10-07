package Services;

import Models.SocketTransceiver;
import java.net.InetAddress;
import java.net.Socket;

public abstract class TcpClient implements Runnable {

	private int port;
	private String hostIP;
	private boolean connect = false;
	private SocketTransceiver transceiver;
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
				public void onReceive(InetAddress addr, String message) {
					TcpClient.this.onReceive(transceiver,message);
				}

				@Override
				public void onDisconnect(InetAddress addr) {
					disconnect();
					connect = false;
					TcpClient.this.onDisconnect(this);
				}

				@Override
				public void onThreadStartSuccess() {
					connect = true;
					TcpClient.this.onConnect(this);
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
