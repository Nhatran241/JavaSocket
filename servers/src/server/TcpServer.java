package server;

import client.TcpClient;
import com.google.gson.Gson;
import javalibrary.SocketTransceiver;
import javalibrary.securedata.SecureDataManager;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.util.ArrayList;
import java.util.List;

public abstract class TcpServer implements Runnable {
    private int port;
    private boolean runFlag;
    private List<SocketTransceiver> clients = new ArrayList();

    public TcpServer(int port) {
        this.port = port;
    }

    public void start() {
        this.runFlag = true;
        (new Thread(this)).start();
    }

    public void stop() {
        this.runFlag = false;
    }

    public List<SocketTransceiver> getClients() {
        return clients;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            while(runFlag) {
                try {
                    Socket socket = serverSocket.accept();
                    handleClientConnect(socket);
                } catch (IOException exception) {
                    onConnectFailed(exception);
                }
            }
            try {
                for (SocketTransceiver client : this.clients) {
                    client.stop();
                }
                clients.clear();
                serverSocket.close();
            } catch (Exception exception) {
                System.out.println(exception.toString());
                this.onConnectFailed(exception);
            }
        } catch (IOException exception) {
            System.out.println(exception.toString());
            this.onConnectFailed(exception);
        }
        this.stop();
        this.onServerStop();
    }

    private void handleClientConnect(Socket socket) {
        SocketTransceiver client = new SocketTransceiver(socket) {
            @Override
            public void onReceive(InetAddress addr, byte[] data) {
                if(secretKey==null){
                  secretKey = SecureDataManager.getInstance().getSecretKey();
                    try {
                        /**
                         * Nhận publickey từ client và dùng nó để mã hóa secretkey
                         */
                        PublicKey publicKey = SecureDataManager.getInstance().createPublicKeyFromBytes(data);
                        send(SecureDataManager.getInstance().EncrpytMessage(secretKey.getEncoded(),publicKey));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        TcpServer.this.onReceiver(this,SecureDataManager.getInstance().DecrpytMessage(data,secretKey));
                    } catch (Exception e) {
                        TcpServer.this.onReceiver(this,new String(data));
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onDisconnect(InetAddress addr) {
                TcpServer.this.onDisconnect(this);
                clients.remove(this);
            }

            @Override
            public void onThreadStartSuccess() {
                this.localKeyPair=SecureDataManager.getInstance().getKeyPair();
                TcpServer.this.clients.add(this);
                TcpServer.this.onConnect(this);
            }
        };
        client.start();
    }

    public abstract void onConnect(SocketTransceiver socketTransceiver);

    public abstract void onConnectFailed(Exception exception);

    public abstract void onReceiver(SocketTransceiver socketTransceiver,String message);

    public abstract void onDisconnect(SocketTransceiver socketTransceiver);

    public abstract void onServerStop();
}
