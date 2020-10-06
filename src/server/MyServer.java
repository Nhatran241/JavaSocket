package server;

import com.google.gson.Gson;
import library.SocketTransceiver;
import library.model.reponse.BaseResponse;
import library.model.request.RelatedTopicRequest;
import library.model.request.SearchRequest;

public class MyServer{
    private static int[][] arr = new int[10][10];
    public static void main(String[] args){
        System.out.println("MainServer running on thread : "+Thread.currentThread().getName());
        TcpServer tcpServer = new TcpServer(6060) {
            @Override
            public void onConnect(SocketTransceiver socketTransceiver) {
                System.out.println("OnConnect "+socketTransceiver.getInetAddress());
            }

            @Override
            public void onConnectFailed(Exception exception) {
                System.out.println("onConnectFailed "+exception.getMessage());
            }

            @Override
            public void onReceiver(SocketTransceiver socketTransceiver, String message) {
                if(message.contains(SearchRequest.class.getName())){
                    SearchRequest request = new Gson().fromJson(message,SearchRequest.class);
                    RequestManager.getInstance().requestSearchTrend(request, new RequestManager.RequestListener() {
                        @Override
                        public void onResponse(BaseResponse baseResponse) {
                            socketTransceiver.send(baseResponse);
                        }
                    });
                }else if(message.contains(RelatedTopicRequest.class.getName())){
                    RelatedTopicRequest request = new Gson().fromJson(message,RelatedTopicRequest.class);
                }

//                if(message.equals("gettrend")){
//                    System.out.println("This client call api on thead name"+Thread.currentThread().getName());
//                    System.out.println(socketTransceiver.getInetAddress()+" request getrend");
//                    HttpClient client = HttpClient.newHttpClient();
//                    HttpRequest request = HttpRequest.newBuilder()
//                            .uri(URI.create("http://localhost:5000"))
//                            .build();
//
//                    try {
//                        HttpResponse<String> response = client.send(request,
//                                HttpResponse.BodyHandlers.ofString());
//                        socketTransceiver.send(response.body().toString());
//                    } catch (IOException | InterruptedException exception) {
//                        System.out.println(exception.toString());
//                    }
//                }
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



}