package server;

import library.SocketTransceiver;
import library.TcpServer;

public class MyServer{
    private static int[][] arr = new int[10][10];
    public static void main(String[] args){
        TcpServer tcpServer = new TcpServer(6060) {
            @Override
            public void onConnect(SocketTransceiver socketTransceiver) {
                System.out.println("OnConnect "+socketTransceiver.getInetAddress());
                socketTransceiver.send("HELLO CLIENT");
            }

            @Override
            public void onConnectFailed(Exception exception) {
                System.out.println("onConnectFailed "+exception.getMessage());
            }

            @Override
            public void onReceiver(SocketTransceiver socketTransceiver, String message) {
                System.out.println("OnReceiver "+socketTransceiver.getInetAddress()+"Message: "+message);

            }

            @Override
            public void onDisconnect(SocketTransceiver socketTransceiver) {
                System.out.println("OnDisconnect "+socketTransceiver.getInetAddress());
            }

            @Override
            public void onServerStop() {

            }
        };
        tcpServer.start();
    }

    private static void handleClientMessage(SocketTransceiver socketTransceiver, String message) {
        System.out.println(message);
        if(socketTransceiver.getNameTag().equals("player0")){
            int posx = Integer.parseInt(message.charAt(0)+"");
            int posy = Integer.parseInt(message.charAt(1)+"");
            arr[posx][posy]=1;
        }else if(socketTransceiver.getNameTag().equals("player1")){
            int posx = Integer.parseInt(message.charAt(0)+"");
            int posy = Integer.parseInt(message.charAt(1)+"");
            arr[posx][posy]=-1;
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


}