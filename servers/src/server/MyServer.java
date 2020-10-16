package server;


import com.google.gson.Gson;
import library.SocketTransceiver;
import library.model.request.*;

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
                if(message.contains(SearchRequest.class.getSimpleName())){
                    SearchRequest request = new Gson().fromJson(message,SearchRequest.class);
                    requestManager.requestSearchTrend(request, socketTransceiver::send);
                }else if(message.contains(RelatedTopicRequest.class.getSimpleName())){
                    RelatedTopicRequest request = new Gson().fromJson(message,RelatedTopicRequest.class);
                    requestManager.requestRelatedTopic(request, socketTransceiver::send);
                }else if(message.contains(CategoriesRequest.class.getSimpleName())){
                    requestManager.requestCategories(socketTransceiver::send);
                }else if(message.contains(SuggestionsKeywordRequest.class.getSimpleName())){
                    requestManager.requestSuggestions(new Gson().fromJson(message,SuggestionsKeywordRequest.class),socketTransceiver::send);
                }else if(message.contains(GeoRequestCountry.class.getSimpleName())){
                    requestManager.requestGeoCountry(socketTransceiver::send);
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