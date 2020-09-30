package client;

import library.SocketTransceiver;

import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {

            }

            @Override
            public void onConnectFailed() {

            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
            }


            @Override
            public void onDisconnect(SocketTransceiver transceiver) {

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