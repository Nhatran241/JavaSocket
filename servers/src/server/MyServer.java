package server;


import com.google.gson.Gson;
import server.library.SocketTransceiver;
import server.library.model.request.CategoriesRequest;
import server.library.model.request.RelatedTopicRequest;
import server.library.model.request.SearchRequest;
import server.library.model.request.SuggestionsKeywordRequest;

public class MyServer{
    public static void main(String[] args){
        System.out.println("MainServer running on thread : "+Thread.currentThread().getName());
        RequestManager requestManager = RequestManager.getInstance();
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
                System.out.println(message);
                if(message.contains(SearchRequest.class.getName())){
                    SearchRequest request = new Gson().fromJson(message,SearchRequest.class);
                    requestManager.requestSearchTrend(request, socketTransceiver::send);
                }else if(message.contains(RelatedTopicRequest.class.getName())){
                    RelatedTopicRequest request = new Gson().fromJson(message,RelatedTopicRequest.class);
                }else if(message.contains(CategoriesRequest.class.getName())){
                    requestManager.requestCategories(socketTransceiver::send);
                }else if(message.contains(SuggestionsKeywordRequest.class.getName())){
                    requestManager.requestSuggestions(new Gson().fromJson(message,SuggestionsKeywordRequest.class),socketTransceiver::send);
                }
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