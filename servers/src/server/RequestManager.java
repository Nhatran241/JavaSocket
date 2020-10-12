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
    public void requestGeoCountry(RequestListener requestListener) {
        requestListener.onResponse("[{\"id\":\"SA\",\"name\":\"Ả Rập Xê-út\"},{\"id\":\"EG\",\"name\":\"Ai Cập\"},{\"id\":\"AT\",\"name\":\"Áo\"},{\"id\":\"AR\",\"name\":\"Argentina\"},{\"id\":\"AU\",\"name\":\"Australia\"},{\"id\":\"IN\",\"name\":\"Ấn Độ\"},{\"id\":\"PL\",\"name\":\"Ba Lan\"},{\"id\":\"BE\",\"name\":\"Bỉ\"},{\"id\":\"PT\",\"name\":\"Bồ Đào Nha\"},{\"id\":\"BR\",\"name\":\"Brazil\"},{\"id\":\"CA\",\"name\":\"Canada\"},{\"id\":\"CL\",\"name\":\"Chile\"},{\"id\":\"CO\",\"name\":\"Colombia\"},{\"id\":\"TW\",\"name\":\"Đài Loan\"},{\"id\":\"DK\",\"name\":\"Đan Mạch\"},{\"id\":\"DE\",\"name\":\"Đức\"},{\"id\":\"NL\",\"name\":\"Hà Lan\"},{\"id\":\"KR\",\"name\":\"Hàn Quốc\"},{\"id\":\"US\",\"name\":\"Hoa Kỳ\"},{\"id\":\"HK\",\"name\":\"Hồng Kông\"},{\"id\":\"HU\",\"name\":\"Hungary\"},{\"id\":\"GR\",\"name\":\"Hy Lạp\"},{\"id\":\"ID\",\"name\":\"Indonesia\"},{\"id\":\"IE\",\"name\":\"Ireland\"},{\"id\":\"IL\",\"name\":\"Israel\"},{\"id\":\"IT\",\"name\":\"Italy\"},{\"id\":\"KE\",\"name\":\"Kenya\"},{\"id\":\"MY\",\"name\":\"Malaysia\"},{\"id\":\"MX\",\"name\":\"Mexico\"},{\"id\":\"NO\",\"name\":\"Na Uy\"},{\"id\":\"ZA\",\"name\":\"Nam Phi\"},{\"id\":\"NZ\",\"name\":\"New Zealand\"},{\"id\":\"RU\",\"name\":\"Nga\"},{\"id\":\"JP\",\"name\":\"Nhật Bản\"},{\"id\":\"NG\",\"name\":\"Nigeria\"},{\"id\":\"FR\",\"name\":\"Pháp\"},{\"id\":\"FI\",\"name\":\"Phần Lan\"},{\"id\":\"PH\",\"name\":\"Philippines\"},{\"id\":\"RO\",\"name\":\"Romania\"},{\"id\":\"CZ\",\"name\":\"Séc\"},{\"id\":\"SG\",\"name\":\"Singapore\"},{\"id\":\"TH\",\"name\":\"Thái Lan\"},{\"id\":\"TR\",\"name\":\"Thổ Nhĩ Kỳ\"},{\"id\":\"SE\",\"name\":\"Thụy Điển\"},{\"id\":\"CH\",\"name\":\"Thụy Sĩ\"},{\"id\":\"UA\",\"name\":\"Ukraina\"},{\"id\":\"VN\",\"name\":\"Việt Nam\"},{\"id\":\"GB\",\"name\":\"Vương quốc Anh\"}]");
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

    public void requestGeos() {
    }


    public interface RequestListener{
        void onResponse(String response);
    }
}
