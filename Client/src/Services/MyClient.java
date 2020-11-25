package Services;

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
import javalibrary.model.reponse.ListRelatedTopicReponse;
import javalibrary.model.reponse.OverTimeReponse;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.request.CategoriesRequest;
import javalibrary.model.request.GeoRequestCountry;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchOvertimeRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;
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

    List<String> keySearchs = new ArrayList<>();

    private static MyClient instance;

    public static MyClient getInstance() {
        if (instance == null) {
            instance = new MyClient();
        }
        return instance;
    }

    public void connect(IConnectListener iConnectListener) {
        TcpClient tcpClient = new TcpClient() {
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
//                System.out.println("message: " + message);

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
                    }
                }
            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                iConnectListener.onDisconnect();
            }
        };
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
        System.out.print("asdasda" + searchOvertimeRequest.getFromDate());
        this.iSearchOvertimeListener = i;
        myClientTranceiver.sendWithEncrypt(searchOvertimeRequest);
    }

    public void SetGeo(String inputString) {
        inputString = inputString.replace(GeoRequestCountry.class.getSimpleName(), "");
        List<Geo> geos = new ArrayList<>();
        geos.add(new Geo("All over the world", "AA"));

        JsonArray jsonArray = new JsonParser().parse(inputString).getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            String id = jsonArray.get(i).getAsJsonObject().get("id").toString();
            String name = jsonArray.get(i).getAsJsonObject().get("name").toString();

            id = id.replace("\"", "");
            name = name.replace("\"", "");
            geos.add(new Geo(name, id));
        }
        iGetGeoListener.onGetGeoSuccess(geos);
    }

    public void setCategory(String inpuString) {
        inpuString = inpuString.replace(CategoriesRequest.class.getSimpleName(), "");
        try {
            JsonObject jsonObject = new JsonParser().parse(inpuString).getAsJsonObject();
            String jsonArray = jsonObject.get("children").toString();
            iGetCategoryListener.onGetCategorySuccess(Categoryrecursive(jsonArray));
        } catch (JsonSyntaxException e) {
            System.out.println(e);
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
                System.out.println(e);
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        iGetSearchRegionListener.OnGetSearchRegionSuccess(searchRegionReponses);
    }

    public void SetSearchRelated(String inputString) {
        List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
        inputString = inputString.replace(SearchRelatedQueryRequest.class.getSimpleName(), "");

        for (int i = 0; i < keySearchs.size(); i++) {
            List<RelatedReponse> relatedReponses = new ArrayList<>();
            JSONParser jSONParser = new JSONParser();
            try {
                JSONObject jSONObject = (JSONObject) jSONParser.parse(inputString);
                jSONObject = (JSONObject) jSONObject.get(keySearchs.get(i));
                JSONObject jSONrising = (JSONObject) jSONObject.get("rising");

                try {
                    JSONArray jSONArray = (JSONArray) jSONrising.get("data");
                    for (int j = 0; j < jSONArray.size(); j++) {
                        JSONArray item = (JSONArray) jSONArray.get(j);
                        String name = item.get(0).toString();
                        name = name.replace("\"", "");
                        String rising = item.get(1).toString();
                        relatedReponses.add(new RelatedReponse(name, rising));
                    }
                    JSONObject jSONtop = (JSONObject) jSONObject.get("top");
                    jSONArray = (JSONArray) jSONtop.get("data");
                    for (int j = 0; j < jSONArray.size(); j++) {
                        JSONArray item = (JSONArray) jSONArray.get(j);
                        String name = item.get(0).toString();
                        name = name.replace("\"", "");
                        String top = item.get(1).toString();
                        for (RelatedReponse relatedReponse : relatedReponses) {
                            if (relatedReponse.getName().equalsIgnoreCase(name)) {
                                relatedReponse.setTop(top);
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } catch (ParseException ex) {
                System.out.println(ex);
            }
            searchRelatedReponses.add(new SearchRelatedReponse(keySearchs.get(i), relatedReponses));
        }
        iSearchRelatedListener.OnGetSearchRelatedSuccess(searchRelatedReponses);
    }

    public void SetSearchRelatedTopic(String inputString) {
        List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();
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
                    searchRelatedTopicReponses.add(new SearchRelatedTopicReponse(name, rising));
                }
                jsonArray = (JSONArray) jSONtop.get("data");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONArray item = (JSONArray) jsonArray.get(i);
                    String top = item.get(0).toString();
                    String name = item.get(5).toString();
                    name = name.replace("\"", "");

                    for (SearchRelatedTopicReponse searchRelatedTopicReponse : searchRelatedTopicReponses) {
                        if (searchRelatedTopicReponse.getName().equalsIgnoreCase(name)) {
                            searchRelatedTopicReponse.setTop(top);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        iSearchRelatedTopicListener.OnGetSearchRelatedTopicSuccess(searchRelatedTopicReponses);
    }

    public void SetRelatedTopic(String inputString) {

        List<RelatedTopicReponse> relatedTopicReponses = new ArrayList<>();
        inputString = inputString.replace(RelatedTopicRequest.class.getSimpleName(), "");
        JSONParser jSONParser = new JSONParser();

        try {
            JSONArray jSONArray = (JSONArray) jSONParser.parse(inputString);
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                if (jSONObject.get("og:title") != null && jSONObject.get("og:url") != null) {
                    RelatedTopicReponse relatedTopicReponse = new RelatedTopicReponse();
                    relatedTopicReponse.setTitle(jSONObject.get("og:title").toString());
                    relatedTopicReponse.setUrl(jSONObject.get("og:url").toString());
                    relatedTopicReponse.setDescription(jSONObject.get("og:description") != null ? jSONObject.get("og:description").toString() : "");
                    relatedTopicReponse.setImage(jSONObject.get("og:image") != null ? jSONObject.get("og:image").toString() : "");
                    relatedTopicReponses.add(relatedTopicReponse);
                }
            }
        } catch (ParseException ex) {
        } finally {
            iRelatedTopicListener.OnGetRelatedTopicSuccess(relatedTopicReponses);
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
                System.out.println(e);
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        iSearchOvertimeListener.OnGetSearchOvertimeSuccess(searchOverTimeReponse);
    }

}
