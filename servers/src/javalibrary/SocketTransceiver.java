package javalibrary;


import com.google.gson.Gson;
import javalibrary.securedata.SecureDataManager;

import javax.crypto.SecretKey;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public abstract class SocketTransceiver implements Runnable {
	protected Socket socket;
	protected InetAddress addr;
	protected DataInputStream in;
	protected DataOutputStream out;
	public KeyPair localKeyPair;
	public SecretKey secretKey;
	private boolean runFlag;
	private String nameTag;


	public SocketTransceiver(Socket socket) {
		this.socket = socket;
		this.addr = socket.getInetAddress();
	}

	public InetAddress getInetAddress() {
		return addr;
	}

	public void start() {
		runFlag = true;
		new Thread(this).start();
	}

	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public void stop() {
		runFlag = false;
//		try {
//			socket.shutdownInput();
//			in.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public boolean send(String s) {
		if (out != null) {
			try {
				byte[] data=s.getBytes("UTF-8");
				out.writeInt(data.length);
				out.write(data);
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean send(byte[] data) {
		if (out != null) {
			try {
				out.writeInt(data.length);
				out.write(data);
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean send(Object object) {
		if (out != null) {
			try {
				byte[] data=new Gson().toJson(object).getBytes("UTF-8");
				out.writeInt(data.length);
				out.write(data);
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean sendWithEncrypt(Object object){
		try {
			byte[] data=new Gson().toJson(object).getBytes("UTF-8");
			if(secretKey!=null){
				return send(SecureDataManager.getInstance().EncrpytMessage(data,secretKey));
			}else return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean sendWithEncrypt(String string){
		try {
			byte[] data=string.getBytes("UTF-8");
			if(secretKey!=null){
				return send(SecureDataManager.getInstance().EncrpytMessage(data,secretKey));
			}else return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void run() {
		System.out.println("This client use thead name"+Thread.currentThread().getName());
		try {
			in = new DataInputStream(this.socket.getInputStream());
			out = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			runFlag = false;
		}
		onThreadStartSuccess();
		while (runFlag) {
			try {
				int length=in.readInt();
				if(length>0) {
					byte[] data = new byte[length];
					in.readFully(data);
						//String str = new String(data, "UTF-8");
					this.onReceive(addr, data);
				}
			} catch (IOException e) {
				System.out.println(e.toString());
				runFlag = false;
			}
		}
		try {
			in.close();
			out.close();
			socket.close();
			in = null;
			out = null;
			socket = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.onDisconnect(addr);
	}

	public abstract void onReceive(InetAddress addr,byte[] data);

	public abstract void onDisconnect(InetAddress addr);

	public abstract void onThreadStartSuccess();

}
