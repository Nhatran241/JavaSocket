import server.SocketTransceiver;
import server.TcpClient;

public class MyClient {  
    public static void main(String[] args) {
        new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println(transceiver.getInetAddress()+" Connected");
                transceiver.send("Hello Server"+System.currentTimeMillis());
            }

            @Override
            public void onConnectFailed() {
                System.out.println("Connect fail");

            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String s) {
                System.out.println(transceiver.getInetAddress()+" Received :"+s);
            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                System.out.println(transceiver.getInetAddress()+" Disconnected");

            }
        }.connect("localhost",6666);
    }
}  