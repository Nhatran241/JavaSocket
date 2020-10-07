package server;

import library.model.reponse.BaseResponse;
import library.model.reponse.SearchResponse;
import library.model.request.SearchRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RequestManager {
    private String baseUrlPythonServer="http://localhost:5000/";
    private static RequestManager instance;

    public static RequestManager getInstance() {
        if(instance == null)
            instance = new RequestManager();
        return instance;
    }
    public void requestSearchTrend(SearchRequest searchRequest,RequestListener requestListener){
        /**
         *  Gui request den server Python
         */
        System.out.println(mappingSearchParam(searchRequest));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrlPythonServer+mappingSearchParam(searchRequest)))
                .build();
        SearchResponse searchResponse;
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            searchResponse = new SearchResponse(response.statusCode());
            requestListener.onResponse(mappingSearchResult(searchResponse,response));
            System.out.println(response.body());
        } catch (InterruptedException interruptedException) {
            searchResponse = new SearchResponse(BaseResponse.interruptedException);
            requestListener.onResponse(searchResponse);
        } catch (IOException ioException) {
            searchResponse = new SearchResponse(BaseResponse.ioException);
            requestListener.onResponse(searchResponse);
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

    private BaseResponse mappingSearchResult(SearchResponse searchResponse, HttpResponse<String> response) {
        List<String> relatedKeyword = new ArrayList<>();
        relatedKeyword.add(response.body());
        searchResponse.setRelatedKeyword(relatedKeyword);
        return searchResponse;
    }

    public interface RequestListener{
        void onResponse(BaseResponse baseResponse);
    }
}
