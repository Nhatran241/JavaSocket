package server;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import library.model.reponse.BaseResponse;
import library.model.request.RelatedTopicRequest;
import library.model.request.SearchRequest;
import library.model.request.SuggestionsKeywordRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class RequestManager {
    private final String baseUrlPythonServer = "http://localhost:5000/";
    private final String requestCategoriesPath = "categories";
    private final String requestSuggestionPath = "suggestions";
    private final String requestSearchPath = "search";
    private static RequestManager instance;

    public static RequestManager getInstance() {
        if (instance == null)
            instance = new RequestManager();
        return instance;
    }

    public void requestSearchTrend(SearchRequest searchRequest, RequestListener requestListener) {
        /**
         *  Gui request den server Python
         */
        sendRequestToPythonServer(baseUrlPythonServer + mappingSearchParam(searchRequest), requestListener);
    }

    public void requestCategories(RequestListener requestListener) {
        sendRequestToPythonServer(baseUrlPythonServer + requestCategoriesPath, requestListener);
    }

    public void requestSuggestions(SuggestionsKeywordRequest suggestionsKeywordRequest, RequestListener requestListener) {
        sendRequestToPythonServer(baseUrlPythonServer + mappingSuggestionParam(suggestionsKeywordRequest), requestListener);
    }

    public void requestGeoCountry(RequestListener requestListener) {
        requestListener.onResponse("[{\"id\":\"SA\",\"name\":\"Ả Rập Xê-út\"},{\"id\":\"EG\",\"name\":\"Ai Cập\"},{\"id\":\"AT\",\"name\":\"Áo\"},{\"id\":\"AR\",\"name\":\"Argentina\"},{\"id\":\"AU\",\"name\":\"Australia\"},{\"id\":\"IN\",\"name\":\"Ấn Độ\"},{\"id\":\"PL\",\"name\":\"Ba Lan\"},{\"id\":\"BE\",\"name\":\"Bỉ\"},{\"id\":\"PT\",\"name\":\"Bồ Đào Nha\"},{\"id\":\"BR\",\"name\":\"Brazil\"},{\"id\":\"CA\",\"name\":\"Canada\"},{\"id\":\"CL\",\"name\":\"Chile\"},{\"id\":\"CO\",\"name\":\"Colombia\"},{\"id\":\"TW\",\"name\":\"Đài Loan\"},{\"id\":\"DK\",\"name\":\"Đan Mạch\"},{\"id\":\"DE\",\"name\":\"Đức\"},{\"id\":\"NL\",\"name\":\"Hà Lan\"},{\"id\":\"KR\",\"name\":\"Hàn Quốc\"},{\"id\":\"US\",\"name\":\"Hoa Kỳ\"},{\"id\":\"HK\",\"name\":\"Hồng Kông\"},{\"id\":\"HU\",\"name\":\"Hungary\"},{\"id\":\"GR\",\"name\":\"Hy Lạp\"},{\"id\":\"ID\",\"name\":\"Indonesia\"},{\"id\":\"IE\",\"name\":\"Ireland\"},{\"id\":\"IL\",\"name\":\"Israel\"},{\"id\":\"IT\",\"name\":\"Italy\"},{\"id\":\"KE\",\"name\":\"Kenya\"},{\"id\":\"MY\",\"name\":\"Malaysia\"},{\"id\":\"MX\",\"name\":\"Mexico\"},{\"id\":\"NO\",\"name\":\"Na Uy\"},{\"id\":\"ZA\",\"name\":\"Nam Phi\"},{\"id\":\"NZ\",\"name\":\"New Zealand\"},{\"id\":\"RU\",\"name\":\"Nga\"},{\"id\":\"JP\",\"name\":\"Nhật Bản\"},{\"id\":\"NG\",\"name\":\"Nigeria\"},{\"id\":\"FR\",\"name\":\"Pháp\"},{\"id\":\"FI\",\"name\":\"Phần Lan\"},{\"id\":\"PH\",\"name\":\"Philippines\"},{\"id\":\"RO\",\"name\":\"Romania\"},{\"id\":\"CZ\",\"name\":\"Séc\"},{\"id\":\"SG\",\"name\":\"Singapore\"},{\"id\":\"TH\",\"name\":\"Thái Lan\"},{\"id\":\"TR\",\"name\":\"Thổ Nhĩ Kỳ\"},{\"id\":\"SE\",\"name\":\"Thụy Điển\"},{\"id\":\"CH\",\"name\":\"Thụy Sĩ\"},{\"id\":\"UA\",\"name\":\"Ukraina\"},{\"id\":\"VN\",\"name\":\"Việt Nam\"},{\"id\":\"GB\",\"name\":\"Vương quốc Anh\"}]");
    }

    public void requestRelatedTopic(RelatedTopicRequest relatedTopicRequest, RequestListener requestListener)
    {
        sendRequestToGoogleCustomSearch(mappingRelatedTopicParam(relatedTopicRequest), requestListener);
    }
    private String mappingSuggestionParam(SuggestionsKeywordRequest suggestionsKeywordRequest) {
        String param = requestSuggestionPath + "?";
        param += "keyword=" + suggestionsKeywordRequest.getKeyword();
        return param;
    }

    private String mappingSearchParam(SearchRequest searchRequest) {
        String param = requestSearchPath + "?";
        StringBuilder tempq = new StringBuilder();
        for (String q :searchRequest.getSearchQuery()){
            tempq.append(q).append(",");
        }
        param += "q=" + tempq.deleteCharAt(tempq.length()-1);
        if (searchRequest.getCategory() != null)
            param += "&cat=" + searchRequest.getCategory().getId();
        if (searchRequest.getGeo() != null)
            param += "&geo=" + searchRequest.getGeo().getId();
        param += "&from=" + searchRequest.getFromDate() + "&to=" + searchRequest.getToDate();
        return param;
    }

    private void sendRequestToPythonServer(String urlRequest, RequestListener requestListener) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest.replace(" ","%20")))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            requestListener.onResponse(response.body());
        } catch (InterruptedException interruptedException) {
            requestListener.onResponse(String.valueOf(BaseResponse.interruptedException));
        } catch (IOException ioException) {
            requestListener.onResponse(String.valueOf(BaseResponse.ioException));
        }
    }

    public void requestGeos() {
    }

    // RELATED TOPIC REQUEST
    private String mappingRelatedTopicParam(RelatedTopicRequest relatedTopicRequest)
    {
        String param = "https://customsearch.googleapis.com/customsearch/v1?";
        param += "cx="+relatedTopicRequest.idSearchEngine;
        if(relatedTopicRequest.getRelatedTopicQuery() != null)
        {
            param += "&q="+relatedTopicRequest.getRelatedTopicQuery().replaceAll(" ","%20");
        }
        param += "&start="+getStartPage(relatedTopicRequest.getPageNumber())+"&fields=items";
        param += "&key="+relatedTopicRequest.apiKeyGoogle;
        return param;
    }

    private void sendRequestToGoogleCustomSearch(String urlRequest, RequestListener requestListener)
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //Format response
            String prettyResponse = filterRelatedTopicResult(response.body());
            requestListener.onResponse(prettyResponse);

        } catch (InterruptedException interruptedException) {
            requestListener.onResponse(String.valueOf(BaseResponse.interruptedException));
        } catch (IOException ioException) {
            requestListener.onResponse(String.valueOf(BaseResponse.ioException));
        }

    }
    public int getStartPage(int pageNumber) { return (pageNumber*10)+1; }
    private String filterRelatedTopicResult(String data) {
        //Response Json Array Metatags
        JSONArray resJaMetatags = new JSONArray();
        //Parse data to JsonPaser
        Object obj = null;
        try {
            obj = new JSONParser().parse(data);
        } catch (ParseException e) {
            System.out.println("Data null");
        }

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        JSONObject jo1 = null;
        // getting items
        JSONArray jaItems = (JSONArray) jo.get("items");
        // iterating items
        Iterator itrItems = jaItems.iterator();
        Iterator<Map.Entry> itrItemsDetail;

        //Duyet element of items
        while (itrItems.hasNext()) {
            itrItemsDetail = ((Map) itrItems.next()).entrySet().iterator();
            //Duyet element item detail in items
            while (itrItemsDetail.hasNext()) {
                Map.Entry pair = itrItemsDetail.next();
                if (!pair.getKey().equals("pagemap")) {
                    continue;
                }
                Map pageMap = (Map) pair.getValue();
                Iterator<Map.Entry> itrPageMap = pageMap.entrySet().iterator();
                //Duyet element of pagemap
                while (itrPageMap.hasNext()) {
                    Map.Entry pairPageMap = itrPageMap.next();
                    if (pairPageMap.getKey().equals("metatags")) {
                        //Get metatags
                        JSONArray jaMetatags = (JSONArray) pairPageMap.getValue();
                        Map metatags = (Map) jaMetatags.get(0);
                        Iterator<Map.Entry> itrMetatags = metatags.entrySet().iterator();

                        resJaMetatags.add(metatags);

                    }
                }
            }
        }
        return resJaMetatags.toJSONString();
    }

    public interface RequestListener {
        void onResponse(String response);
    }
}
