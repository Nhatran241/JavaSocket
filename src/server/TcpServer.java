package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TcpServer implements Runnable {
    private int port;
    private boolean runFlag;
    private List<SocketTransceiver> clients = new ArrayList();

    public TcpServer(int var1) {
        this.port = var1;
    }

    public void start() {
        this.runFlag = true;
        (new Thread(this)).start();
    }

    public void stop() {
        this.runFlag = false;
    }

    public void run() {
        try {
            ServerSocket var1 = new ServerSocket(this.port);

            while(this.runFlag) {
                try {
                    Socket var2 = var1.accept();
                    this.handleClientConnect(var2);
                } catch (IOException var4) {
                    var4.printStackTrace();
                    this.onConnectFailed();
                }
            }

            try {
                Iterator var7 = this.clients.iterator();

                while(var7.hasNext()) {
                    SocketTransceiver var3 = (SocketTransceiver)var7.next();
                    var3.stop();
                }

                this.clients.clear();
                var1.close();
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        this.onServerStop();
    }

    private void handleClientConnect(Socket var1) {
        SocketTransceiver client = new SocketTransceiver(var1) {
            @Override
            public void onReceive(InetAddress addr, String s) {
                TcpServer.this.onReceive(this,addr+":"+s);
            }

            @Override
            public void onDisconnect(InetAddress addr) {
                TcpServer.this.onDisconnect(this);
            }
        };
        client.start();
        this.clients.add(client);
        this.onConnect(client);
    }

    public abstract void onConnect(SocketTransceiver var1);

    public abstract void onConnectFailed();

    public abstract void onReceive(SocketTransceiver var1, String var2);

    public abstract void onDisconnect(SocketTransceiver var1);

    public abstract void onServerStop();
}
