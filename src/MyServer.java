import server.SocketTransceiver;
import server.TcpServer;

public class MyServer {
    public static void main(String[] args){
        new TcpServer(6666) {
            @Override
            public void onConnect(SocketTransceiver var1) {
                var1.send("Hello Server"+var1.getInetAddress());
            }

            @Override
            public void onConnectFailed() {

            }

            @Override
            public void onReceive(SocketTransceiver var1, String var2) {
                System.out.println(var1.getInetAddress() +" received:" +var2);

            }

            @Override
            public void onDisconnect(SocketTransceiver var1) {
                System.out.println(var1.getInetAddress() +" disconnected");
            }

            @Override
            public void onServerStop() {
                System.out.println("TCP Server stop");
            }
        }.start();
    }
}  