package server;


import server.library.model.reponse.BaseResponse;
import server.library.model.request.SearchRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestManager {
    private String baseUrlPythonServer="http://localhost:5000/";
    private static RequestManager instance;

    public static RequestManager getInstance() {
        if(instance == null)
            instance = new RequestManager();
        return instance;
    }
    public void requestSearchTrend(SearchRequest searchRequest, RequestListener requestListener){
        /**
         *  Gui request den server Python
         */
        System.out.println(mappingSearchParam(searchRequest));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrlPythonServer+mappingSearchParam(searchRequest)))
                .build();
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            requestListener.onResponse(response.body());
        } catch (InterruptedException interruptedException) {
            requestListener.onResponse(String.valueOf(BaseResponse.interruptedException));
        } catch (IOException ioException) {
            requestListener.onResponse(String.valueOf(BaseResponse.ioException));
        }
    }

    private String mappingSearchParam(SearchRequest searchRequest) {
        String param="search?";
        param += "q=" + searchRequest.getSearchQuery();
        if(searchRequest.getCategory()!=null)
            param +="&cat="+searchRequest.getCategory().getCategoryCode();
        if(searchRequest.getGeo()!=null)
            param +="&geo="+searchRequest.getGeo().getGeoCode();
        param+="&from="+searchRequest.getFromDate()+"&to="+searchRequest.getToDate();
        return param;
    }

    public interface RequestListener{
        void onResponse(String response);
    }
}
