package library;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
                    System.out.println("Number client connected"+clients.size());
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
//        List<InetAddress> inetAddressList = new ArrayList<>();
//        for (SocketTransceiver socketTransceiver : clients){
//            inetAddressList.add(socketTransceiver.getInetAddress());
//        }
//        if(inetAddressList.contains(socket.getInetAddress())) {
//            try {
//                socket.close();
//            } catch (IOException exception) {
//                exception.printStackTrace();
//            }
//            return;
//        }
        SocketTransceiver client = new SocketTransceiver(socket) {
            @Override
            public void onReceive(InetAddress addr, String message) {
               System.out.println(message);
            }

            @Override
            public void onDisconnect(InetAddress addr) {
                TcpServer.this.onDisconnect(this);
                clients.remove(this);
            }
        };
        client.start();
        this.clients.add(client);
        this.onConnect(client);
    }

    public abstract void onConnect(SocketTransceiver socketTransceiver);

    public abstract void onConnectFailed(Exception exception);

    public abstract void onReceiver(SocketTransceiver socketTransceiver,String message);

    public abstract void onDisconnect(SocketTransceiver socketTransceiver);

    public abstract void onServerStop();
}
