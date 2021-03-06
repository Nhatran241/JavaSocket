package server;


import com.google.gson.Gson;
import javalibrary.SocketTransceiver;
import javalibrary.model.request.*;
import javalibrary.securedata.SecureDataManager;

import java.security.KeyPair;

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
                if(message.contains(SearchRegionRequest.class.getSimpleName())){
                    SearchRegionRequest request = new Gson().fromJson(message, SearchRegionRequest.class);
                    requestManager.requestSearchInterestRegion(request, (RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(SearchRegionRequest.class.getSimpleName()+s));
                }
                else if(message.contains(SearchOvertimeRequest.class.getSimpleName())){
                    SearchOvertimeRequest request = new Gson().fromJson(message,SearchOvertimeRequest.class);
                    requestManager.requestSearchOvertime(request, (RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(SearchOvertimeRequest.class.getSimpleName()+s));
                }
                else if(message.contains(SearchRelatedQueryRequest.class.getSimpleName())){
                    SearchRelatedQueryRequest request = new Gson().fromJson(message, SearchRelatedQueryRequest.class);
                    requestManager.requestSearchRelatedQuery(request, (RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(SearchRelatedQueryRequest.class.getSimpleName()+s.replace("\":\"","\":").replace("\\","\"").replace("\"\"","\"").replace("}\",\"","},\"").replace("}\"}","}}")));
                }else if(message.contains(SearchRelatedTopicRequest.class.getSimpleName())){
                    SearchRelatedTopicRequest request = new Gson().fromJson(message, SearchRelatedTopicRequest.class);
                    requestManager.requestSearchRelatedTopic(request, (RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(SearchRelatedTopicRequest.class.getSimpleName()+s.replace("\":\"","\":").replace("\\","\"").replace("\"\"","\"").replace("}\",\"","},\"").replace("}\"}","}}").replace("\"/","")));
                }else if(message.contains(RelatedTopicRequest.class.getSimpleName())){
                    RelatedTopicRequest request = new Gson().fromJson(message,RelatedTopicRequest.class);
                    requestManager.requestRelatedTopic(request, (RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(RelatedTopicRequest.class.getSimpleName()+s));
                }else if(message.contains(CategoriesRequest.class.getSimpleName())){
                    requestManager.requestCategories(s -> socketTransceiver.sendWithEncrypt(CategoriesRequest.class.getSimpleName()+s));
                }else if(message.contains(SuggestionsKeywordRequest.class.getSimpleName())){
                    requestManager.requestSuggestions(new Gson().fromJson(message,SuggestionsKeywordRequest.class),(RequestManager.RequestListener) s -> socketTransceiver.sendWithEncrypt(SuggestionsKeywordRequest.class.getSimpleName()+s));
                }else if(message.contains(GeoRequestCountry.class.getSimpleName())){
                    requestManager.requestGeoCountry(s -> socketTransceiver.sendWithEncrypt(GeoRequestCountry.class.getSimpleName()+s));
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