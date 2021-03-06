package Services;

import Services.Interfaces.Interfaces;
import Services.Interfaces.Interfaces.IConnectListener;
import Services.Interfaces.Interfaces.IGetCategoryListener;
import Services.Interfaces.Interfaces.IGetGeoListener;
import Services.Interfaces.Interfaces.IGetSearchRegionListener;
import Services.Interfaces.Interfaces.IRelatedTopicListener;
import Services.Interfaces.Interfaces.ISearchOvertimeListener;
import Services.Interfaces.Interfaces.ISearchRelatedListener;
import Services.Interfaces.Interfaces.ISearchRelatedTopicListener;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javalibrary.SocketTransceiver;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.reponse.OverTimeReponse;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.RelatedTopicRising;
import javalibrary.model.reponse.RelatedTopicTop;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.reponse.SuggesstionKeywordResponse;
import javalibrary.model.reponse.SuggesstionResponse;
import javalibrary.model.request.CategoriesRequest;
import javalibrary.model.request.GeoRequestCountry;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchOvertimeRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;
import javalibrary.model.request.SuggestionsKeywordRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyClient {

    private SocketTransceiver myClientTranceiver;
    private IGetGeoListener iGetGeoListener;
    private IGetCategoryListener iGetCategoryListener;
    private IGetSearchRegionListener iGetSearchRegionListener;
    private ISearchRelatedListener iSearchRelatedListener;
    private ISearchRelatedTopicListener iSearchRelatedTopicListener;
    private IRelatedTopicListener iRelatedTopicListener;
    private ISearchOvertimeListener iSearchOvertimeListener;
    private Interfaces.ISuggestionKeywordListener iSuggestionKeywordListener;

    List<String> keySearchs = new ArrayList<>();

    private static MyClient instance;
    private TcpClient tcpClient;

    public static MyClient getInstance() {
        if (instance == null) {
            instance = new MyClient();
        }
        return instance;
    }
    public void init(IConnectListener iConnectListener){
            tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver tra) {
                myClientTranceiver = tra;
                iConnectListener.onConnectSuccess();
            }

            @Override
            public void onConnectFailed() {
                iConnectListener.onConnectFailed();
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
                System.out.println(message);
                if (!message.isEmpty()) {
                    if (message.contains(GeoRequestCountry.class.getSimpleName())) {
                        SetGeo(message);
                    } else if (message.contains(CategoriesRequest.class.getSimpleName())) {
                        setCategory(message);
                    } else if (message.contains(SearchRegionRequest.class.getSimpleName())) {
                        SetSearchRegion(message);
                    } else if (message.contains(SearchRelatedQueryRequest.class.getSimpleName())) {
                        SetSearchRelated(message);
                    } else if (message.contains(SearchRelatedTopicRequest.class.getSimpleName())) {
                        SetSearchRelatedTopic(message);
                    } else if (message.contains(RelatedTopicRequest.class.getSimpleName())) {
                        SetRelatedTopic(message);
                    } else if (message.contains(SearchOvertimeRequest.class.getSimpleName())) {
                        setSearchOvertime(message);
                    } else if (message.contains(SuggestionsKeywordRequest.class.getSimpleName())){
                        setSuggestionKeyword(message);
                    }
                }
            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                iConnectListener.onDisconnect();
            }
        };
    }

    public void connect() {
        tcpClient.connect("gettrend.tk", 6060);
    }

    public void getGeo(IGetGeoListener i) {
        this.iGetGeoListener = i;
        this.myClientTranceiver.sendWithEncrypt(new GeoRequestCountry());
    }

    public void getCategory(IGetCategoryListener i) {
        this.iGetCategoryListener = i;
        myClientTranceiver.sendWithEncrypt(new CategoriesRequest());
    }

    public void getSearchRegion(SearchRegionRequest searchRequest, IGetSearchRegionListener i) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRequest.getSearchQuery());
        this.iGetSearchRegionListener = i;
        myClientTranceiver.sendWithEncrypt(searchRequest);
    }

    public void getSearchRelated(SearchRelatedQueryRequest searchRelatedQueryRequest, ISearchRelatedListener iSearchRelatedListener) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRelatedQueryRequest.getSearchQuery());
        this.iSearchRelatedListener = iSearchRelatedListener;
        myClientTranceiver.sendWithEncrypt(searchRelatedQueryRequest);
    }

    public void getSearchRelatedTopic(SearchRelatedTopicRequest searchRelatedTopicRequest, ISearchRelatedTopicListener i) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRelatedTopicRequest.getSearchQuery());
        this.iSearchRelatedTopicListener = i;
        myClientTranceiver.sendWithEncrypt(searchRelatedTopicRequest);
    }

    public void getRelatedTopic(RelatedTopicRequest relatedTopicRequest, IRelatedTopicListener i) {
        this.iRelatedTopicListener = i;
        myClientTranceiver.sendWithEncrypt(relatedTopicRequest);
    }

    public void getSearchOvertime(SearchOvertimeRequest searchOvertimeRequest, ISearchOvertimeListener i) {
        this.iSearchOvertimeListener = i;
        myClientTranceiver.sendWithEncrypt(searchOvertimeRequest);
    }
    
    public void getSuggestionKeyword(SuggestionsKeywordRequest suggestionsKeywordRequest,Interfaces.ISuggestionKeywordListener i){
        this.iSuggestionKeywordListener = i;
        myClientTranceiver.sendWithEncrypt(suggestionsKeywordRequest);
    }

    public void SetGeo(String inputString) {
        inputString = inputString.replace(GeoRequestCountry.class.getSimpleName(), "");
        List<Geo> geos = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(inputString);
             for (int i = 0; i < jsonArray.size(); i++) {
                 JSONObject object = (JSONObject) jsonArray.get(i);
            String id = object.get("id").toString();
            String name = object.get("name").toString();
            geos.add(new Geo(name, id));
        }
        iGetGeoListener.onGetGeoSuccess(geos);
        } catch (Exception ex) {
            iGetGeoListener.onGetGeoFailed();
        }
    }

    public void setCategory(String inpuString) {
        inpuString = inpuString.replace(CategoriesRequest.class.getSimpleName(), "");
        try {
            JsonObject jsonObject = new JsonParser().parse(inpuString).getAsJsonObject();
            String jsonArray = jsonObject.get("children").toString();
            iGetCategoryListener.onGetCategorySuccess(Categoryrecursive(jsonArray));
        } catch (Exception e) {
            iGetCategoryListener.onGetCategoryFailed();
        }
    }

    public List<Category> Categoryrecursive(String inputString) {
        List<Category> categorys = new ArrayList<>();
        categorys.add(new Category("All catagories", "0"));
        JsonArray jsonArray = new JsonParser().parse(inputString).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {

            String id = jsonArray.get(i).getAsJsonObject().get("id").toString();
            String name = jsonArray.get(i).getAsJsonObject().get("name").toString();
            id = id.replace("\"", "");
            name = name.replace("\"", "");

            if (jsonArray.get(i).getAsJsonObject().get("children") != null) {
                String children = jsonArray.get(i).getAsJsonObject().get("children").toString();
                categorys.add(new Category(name, id, Categoryrecursive(children)));
            } else {
                Category category = new Category(name, id);
                categorys.add(category);
            }
        }
        return categorys;
    }

    public void SetSearchRegion(String inputString) {
        inputString = inputString.replace(SearchRegionRequest.class.getSimpleName(), "");

        List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
        JSONParser jSONParser = new JSONParser();
        try {
            JSONObject jSONObject = (JSONObject) jSONParser.parse(inputString);
            try {
                for (int i = 0; i < keySearchs.size(); i++) {
                    List<RegionReponse> regionReponses = new ArrayList<>();

                    JSONArray dataArray = (JSONArray) jSONObject.get("data");
                    JSONArray indexArray = (JSONArray) jSONObject.get("index");
                    for (int j = 0; j < indexArray.size(); j++) {

                        String name = indexArray.get(j).toString();
                        name = name.replace("\"", "");
                        JSONArray item = (JSONArray) dataArray.get(j);
                        String total = item.get(i).toString();

                        regionReponses.add(new RegionReponse(total, name));
                    }
                    searchRegionReponses.add(new SearchRegionReponse(keySearchs.get(i), regionReponses));
                }
            } catch (Exception e) {
                iGetSearchRegionListener.OnGetSearchRegionFailed();
            }
            iGetSearchRegionListener.OnGetSearchRegionSuccess(searchRegionReponses);
        } catch (Exception ex) {
            iGetSearchRegionListener.OnGetSearchRegionFailed();
        }

    }

    public void SetSearchRelated(String inputString) {
        List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
        inputString = inputString.replace(SearchRelatedQueryRequest.class.getSimpleName(), "");
        JSONParser jSONParser = new JSONParser();
        JSONObject jSONObject;
        try {
            jSONObject = (JSONObject) jSONParser.parse(inputString);
            for (int i = 0; i < keySearchs.size(); i++) {
                List<RelatedReponse> listItem = new ArrayList<>();
                JSONObject jSONObjectKey = (JSONObject) jSONObject.get(keySearchs.get(i).trim());
                JSONObject raising = (JSONObject) jSONObjectKey.get("rising");
                JSONObject top = (JSONObject) jSONObjectKey.get("top");
                if(raising != null && top != null){
                JSONArray raisingData = (JSONArray) raising.get("data");
                JSONArray topData = (JSONArray) top.get("data");

                    for (int j = 0; j < raisingData.size(); j++) {
                        JSONArray itemDataRaising = (JSONArray) raisingData.get(j);
                        JSONArray itemDataTop = (JSONArray) topData.get(j);
                        String name = (String) itemDataRaising.get(0);
                        String raisingdata = itemDataRaising.get(1).toString();
                        String topdata = itemDataTop.get(1).toString();
                        listItem.add(new RelatedReponse(name, raisingdata, topdata));
                    }
                }
                searchRelatedReponses.add(new SearchRelatedReponse(keySearchs.get(i), listItem));
            }
            iSearchRelatedListener.OnGetSearchRelatedSuccess(searchRelatedReponses);
        } catch (Exception ex) {
            iSearchRelatedListener.OnGetSearchRelatedFailed();
        }
    }

    public void SetSearchRelatedTopic(String inputString) {
        List<RelatedTopicRising> relatedTopicRisings = new ArrayList<>();
        List<RelatedTopicTop> relatedTopicTops = new ArrayList<>();
        inputString = inputString.replace(SearchRelatedTopicRequest.class.getSimpleName(), "");

        JSONParser jSONParser = new JSONParser();
        try {
            JSONObject jSONObject = (JSONObject) jSONParser.parse(inputString);
            jSONObject = (JSONObject) jSONObject.get(keySearchs.get(0));
            JSONObject jSONrising = (JSONObject) jSONObject.get("rising");
            JSONObject jSONtop = (JSONObject) jSONObject.get("top");
            try {
                JSONArray jsonArray = (JSONArray) jSONrising.get("data");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONArray item = (JSONArray) jsonArray.get(i);
                    String rising = item.get(0).toString();
                    String name = item.get(4).toString();
                    name = name.replace("\"", "");
                    relatedTopicRisings.add(new RelatedTopicRising(name, rising));
                }
                jsonArray = (JSONArray) jSONtop.get("data");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONArray item = (JSONArray) jsonArray.get(i);
                    String top = item.get(0).toString();
                    String name = item.get(5).toString();
                    name = name.replace("\"", "");
                    relatedTopicTops.add(new RelatedTopicTop(name, top));
                }
            } catch (Exception e) {
                iSearchRelatedTopicListener.OnGetSearchRelatedTopicFailed();
            }
            iSearchRelatedTopicListener.OnGetSearchRelatedTopicSuccess(new SearchRelatedTopicReponse(relatedTopicRisings, relatedTopicTops));
        } catch (Exception ex) {
            iSearchRelatedTopicListener.OnGetSearchRelatedTopicFailed();
        } 

    }

    public void SetRelatedTopic(String inputString) {

        List<RelatedTopicReponse> relatedTopicReponses = new ArrayList<>();
        inputString = inputString.replace(RelatedTopicRequest.class.getSimpleName(), "");
        JSONParser jSONParser = new JSONParser();
        try {
            JSONObject items = (JSONObject) jSONParser.parse(inputString);
            JSONArray jSONArray = (JSONArray) items.get("items");
            if(jSONArray.size() == 0){
                iRelatedTopicListener.OnGetRelatedTopicFailed();
                return;
            }
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                if (jSONObject.get("title") != null && jSONObject.get("link") != null) {
                    RelatedTopicReponse relatedTopicReponse = new RelatedTopicReponse();
                    relatedTopicReponse.setTitle(jSONObject.get("title").toString());
                    relatedTopicReponse.setUrl(jSONObject.get("link").toString());
                    relatedTopicReponse.setDescription(jSONObject.get("snippet") != null ? jSONObject.get("snippet").toString() : "");
                    relatedTopicReponse.setImage("");
                    JSONObject pagemap = (JSONObject) jSONObject.get("pagemap");
                    if(pagemap != null){
                        JSONArray thum = (JSONArray) pagemap.get("cse_thumbnail");
                        if(thum != null && thum.size() >0){
                            JSONObject scr = (JSONObject) thum.get(0);
                            if(scr!=null && scr.get("src")!=null)
                                relatedTopicReponse.setImage(scr.get("src").toString());
                        }
                    }
                    relatedTopicReponses.add(relatedTopicReponse);
                }
            }
            iRelatedTopicListener.OnGetRelatedTopicSuccess(relatedTopicReponses);
        } catch (Exception ex) {
            iRelatedTopicListener.OnGetRelatedTopicFailed();
        }
    }

    public void setSearchOvertime(String inputString) {
        inputString = inputString.replace(SearchOvertimeRequest.class.getSimpleName(), "");
        SearchOverTimeReponse searchOverTimeReponse = new SearchOverTimeReponse();
        List<Long> item = new ArrayList<>();
        List<OverTimeReponse> overTimeReponses = new ArrayList<>();

        JSONParser jSONParser = new JSONParser();
        try {
            JSONObject jSONObject = (JSONObject) jSONParser.parse(inputString);

            try {
                JSONArray jsonIndex = (JSONArray) jSONObject.get("index");
                JSONArray jsonData = (JSONArray) jSONObject.get("data");
                for (int i = 0; i < jsonIndex.size(); i++) {
                    item.add(Long.parseLong(jsonIndex.get(i).toString()));
                }
                JSONArray jSONArray = (JSONArray) jsonData.get(0);
                for (int i = 0; i < (jSONArray.size() - 1); i++) {
                    List<Integer> number = new ArrayList<>();
                    for (int j = 0; j < jsonData.size(); j++) {
                        JSONArray iArray = (JSONArray) jsonData.get(j);
                        number.add(Integer.parseInt(iArray.get(i).toString()));
                    }
                    overTimeReponses.add(new OverTimeReponse(number));
                }

                searchOverTimeReponse.setIndex(item);
                searchOverTimeReponse.setOverTimeReponses(overTimeReponses);
            } catch (Exception e) {
            iSearchOvertimeListener.OnGetSearchOvertimeFailed();
            }
            
            iSearchOvertimeListener.OnGetSearchOvertimeSuccess(searchOverTimeReponse);
        } catch (Exception ex) {
            iSearchOvertimeListener.OnGetSearchOvertimeFailed();
        }
    }
    
    
    public void setSuggestionKeyword(String inputString){
        inputString = inputString.replace(SuggestionsKeywordRequest.class.getSimpleName(), "");
        SuggesstionKeywordResponse suggesstionKeywordResponse = new SuggesstionKeywordResponse();
        List<SuggesstionResponse> keyword = new ArrayList<>();
        
        JSONParser jSONParser = new JSONParser();
            try {
                JSONArray jsonData = (JSONArray)jSONParser.parse(inputString);
                for (int i = 0; i < jsonData.size(); i++) {
                    JSONObject data = (JSONObject) jsonData.get(i);
                    keyword.add(new SuggesstionResponse(data.get("title").toString(), data.get("type").toString()));
                }
                suggesstionKeywordResponse.setResponse(keyword);
            iSuggestionKeywordListener.OnGetSuggestionKeywordSuccess(suggesstionKeywordResponse);
            } catch (Exception e) {
                iSuggestionKeywordListener.OnGetSuggestionKeywordFailed();
            }
    }
}
