package client;

import library.SocketTransceiver;
import library.TcpClient;

import java.io.InputStream;
import java.io.OutputStream;
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
            public void onReceive(SocketTransceiver transceiver, InputStream inputStream, OutputStream outputStream) {

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