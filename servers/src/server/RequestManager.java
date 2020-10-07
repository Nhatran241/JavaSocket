package server;


import server.library.model.reponse.BaseResponse;
import server.library.model.request.BaseRequest;
import server.library.model.request.SearchRequest;
import server.library.model.request.SuggestionsKeywordRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestManager {
    private final String baseUrlPythonServer="http://localhost:5000/";
    private final String requestCategoriesPath="categories";
    private final String requestSuggestionPath="suggestions";
    private final String requestSearchPath="search";
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
        sendRequestToPythonServer(baseUrlPythonServer+mappingSearchParam(searchRequest),requestListener);
    }
    public void requestCategories(RequestListener requestListener){
       sendRequestToPythonServer(baseUrlPythonServer+requestCategoriesPath,requestListener);
    }

    public void requestSuggestions(SuggestionsKeywordRequest suggestionsKeywordRequest,RequestListener requestListener) {
       sendRequestToPythonServer(baseUrlPythonServer+mappingSuggestionParam(suggestionsKeywordRequest),requestListener);
    }

    private String mappingSuggestionParam(SuggestionsKeywordRequest suggestionsKeywordRequest) {
        String param=requestSuggestionPath+"?";
        param += "keyword=" + suggestionsKeywordRequest.getKeyword();
        return param;
    }

    private String mappingSearchParam(SearchRequest searchRequest) {
        String param=requestSearchPath+"?";
        param += "q=" + searchRequest.getSearchQuery();
        if(searchRequest.getCategory()!=null)
            param +="&cat="+searchRequest.getCategory().getCategoryCode();
        if(searchRequest.getGeo()!=null)
            param +="&geo="+searchRequest.getGeo().getGeoCode();
        param+="&from="+searchRequest.getFromDate()+"&to="+searchRequest.getToDate();
        return param;
    }

    private void sendRequestToPythonServer(String urlRequest,RequestListener requestListener) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest))
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


    public interface RequestListener{
        void onResponse(String response);
    }
}
