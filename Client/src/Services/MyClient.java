package Services;

import Models.Category;
import Models.Geo;
import Models.SearchRequest;
import Models.SearchResponse;
import Models.SocketTransceiver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                List searchList = new ArrayList<String>();
                searchList.add("trump");
                
                System.out.println("Connected to"+transceiver.getInetAddress());
                SearchRequest searchRequest = new SearchRequest();
                
                searchRequest.setSearchQuery(searchList);
                searchRequest.setGeo(new Geo("Viet Name","VN"));
                searchRequest.setCategory(new Category("Pháp luật chính trị","19"));
                Calendar c = Calendar.getInstance();
                Date dt = new Date();
                c.setTime(dt);
                c.add(Calendar.YEAR, -1);
                searchRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                
                transceiver.send(searchRequest);
            }

            @Override
            public void onConnectFailed() {
                System.out.println("connection failed");
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
                System.out.println(message);
                if(message.contains(SearchRequest.class.getName())){
                    
                }
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