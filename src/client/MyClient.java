package client;

import library.SocketTransceiver;

import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Connected to"+transceiver.getInetAddress());
                transceiver.send("gettrend");
            }

            @Override
            public void onConnectFailed() {
                System.out.println("connection failed");
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
                System.out.println(message);
            }


            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                System.out.println("disconnected");

            }
        };
        tcpClient.connect("localhost",6060);

    }

    private static void sendMessageLoop(TcpClient tcpClient, SocketTransceiver transceiver) {
        Scanner scanner = new Scanner(System.in);
        while (tcpClient.isConnected()){
            transceiver.send(scanner.nextLine()+"");
        }
    }
}  