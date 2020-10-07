package server.library;


import com.google.gson.Gson;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public abstract class SocketTransceiver implements Runnable {

	protected Socket socket;
	protected InetAddress addr;
	protected DataInputStream in;
	protected DataOutputStream out;
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
				out.writeUTF(s);
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
				out.writeUTF(new Gson().toJson(object));
				out.flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
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
				final String s = in.readUTF();
				this.onReceive(addr, s);
			} catch (IOException e) {
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

	public abstract void onReceive(InetAddress addr,String message);

	public abstract void onDisconnect(InetAddress addr);

	public abstract void onThreadStartSuccess();

}
