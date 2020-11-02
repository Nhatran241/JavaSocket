package Services;

import Services.Interfaces.Interfaces.IConnectListener;
import Services.Interfaces.Interfaces.IGetCategoryListener;
import Services.Interfaces.Interfaces.IGetGeoListener;
import Services.Interfaces.Interfaces.IGetSearchRegionListener;
import Services.Interfaces.Interfaces.IRelatedTopicListener;
import Services.Interfaces.Interfaces.ISearchRelatedListener;
import Services.Interfaces.Interfaces.ISearchRelatedTopicListener;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import javalibrary.SocketTransceiver;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.request.CategoriesRequest;
import javalibrary.model.request.GeoRequestCountry;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;

public class MyClient {

    private SocketTransceiver myClientTranceiver;
    private IGetGeoListener iGetGeoListener;
    private IGetCategoryListener iGetCategoryListener;
    private IGetSearchRegionListener iGetSearchRegionListener;
    private ISearchRelatedListener iSearchRelatedListener;
    private ISearchRelatedTopicListener iSearchRelatedTopicListener;
    private IRelatedTopicListener iRelatedTopicListener;

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
                System.out.println("message: " + message);

                if (!message.isEmpty()) {
                    if (message.contains(GeoRequestCountry.class.getSimpleName())) {

                        iGetGeoListener.onGetGeoSuccess(SetGeo(message));
                    } else if (message.contains(CategoriesRequest.class.getSimpleName())) {
                        message = message.replace(CategoriesRequest.class.getSimpleName(), "");
                        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
                        String jsonArray = jsonObject.get("children").toString();

                        iGetCategoryListener.onGetCategorySuccess(SetCategoryrecursive(jsonArray));
                    } else if (message.contains(SearchRegionRequest.class.getSimpleName())) {

                        iGetSearchRegionListener.OnGetSearchRegionSuccess(SetSearchRegion(message));
                    } else if (message.contains(SearchRelatedQueryRequest.class.getSimpleName())) {

                        iSearchRelatedListener.OnGetSearchRelatedSuccess(SetSearchRelated(message));
                    } else if (message.contains(SearchRelatedTopicRequest.class.getSimpleName())) {

                        iSearchRelatedTopicListener.OnGetSearchRelatedTopicSuccess(SetSearchRelatedTopic(message));
                    } else if (message.contains(RelatedTopicRequest.class.getSimpleName())) {

                        iRelatedTopicListener.OnGetRelatedTopicSuccess(SetRelatedTopic(message));
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
        this.myClientTranceiver.send(new GeoRequestCountry());
    }

    public void getCategory(IGetCategoryListener i) {
        this.iGetCategoryListener = i;
        myClientTranceiver.send(new CategoriesRequest());
    }

    public void getSearchRegion(SearchRegionRequest searchRequest, IGetSearchRegionListener i) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRequest.getSearchQuery());
        this.iGetSearchRegionListener = i;
        myClientTranceiver.send(searchRequest);
    }

    public void getSearchRelated(SearchRelatedQueryRequest searchRelatedQueryRequest, ISearchRelatedListener iSearchRelatedListener) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRelatedQueryRequest.getSearchQuery());
        this.iSearchRelatedListener = iSearchRelatedListener;
        myClientTranceiver.send(searchRelatedQueryRequest);
    }

    public void getSearchRelatedTopic(SearchRelatedTopicRequest searchRelatedTopicRequest, ISearchRelatedTopicListener i) {
        this.keySearchs.clear();
        keySearchs.addAll(searchRelatedTopicRequest.getSearchQuery());
        this.iSearchRelatedTopicListener = i;
        myClientTranceiver.send(searchRelatedTopicRequest);
    }

    public void getRelatedTopic(RelatedTopicRequest relatedTopicRequest, IRelatedTopicListener i) {
        this.iRelatedTopicListener = i;
        myClientTranceiver.send(relatedTopicRequest);

    }

    public List<Geo> SetGeo(String inputString) {
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

        return geos;
    }

    public List<Category> SetCategoryrecursive(String inputString) {
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
                categorys.add(new Category(name, id, SetCategoryrecursive(children)));
            } else {
                Category category = new Category(name, id);
                categorys.add(category);
            }
        }
        return categorys;
    }

    public List<SearchRegionReponse> SetSearchRegion(String inputString) {
        inputString = inputString.replace(SearchRegionRequest.class.getSimpleName(), "");
        List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject();

        for (int i = 0; i < keySearchs.size(); i++) {
            List<RegionReponse> regionReponses = new ArrayList<>();

            JsonArray dataArray = (JsonArray) jsonObject.get("data");
            JsonArray indexArray = (JsonArray) jsonObject.get("index");
            for (int j = 0; j < indexArray.size(); j++) {

                String name = indexArray.get(j).toString();
                JsonArray item = (JsonArray) dataArray.get(j);
                String total = item.get(i).toString();

                regionReponses.add(new RegionReponse(total, name));
            }
            searchRegionReponses.add(new SearchRegionReponse(keySearchs.get(i), regionReponses));
        }
        return searchRegionReponses;
    }

    public List<SearchRelatedReponse> SetSearchRelated(String inputString) {
        List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
        inputString = inputString.replace(SearchRelatedQueryRequest.class.getSimpleName(), "");

        for (int i = 0; i < keySearchs.size(); i++) {
            List<RelatedReponse> relatedReponses = new ArrayList<>();

            JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(i)).getAsJsonObject().get("rising");
            JsonArray jsonArray = (JsonArray) jsonObject.get("data");
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonArray item = (JsonArray) jsonArray.get(j);

                String name = item.get(0).toString();
                String rising = item.get(1).toString();

                relatedReponses.add(new RelatedReponse(name, rising));
            }
            jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(i)).getAsJsonObject().get("top");
            jsonArray = (JsonArray) jsonObject.get("data");
            for (JsonElement jsonElement : jsonArray) {
                JsonArray item = (JsonArray) jsonElement;
                String name = item.get(0).toString();
                String top = item.get(1).toString();
                for (RelatedReponse relatedReponse : relatedReponses) {
                    if (relatedReponse.getName().equalsIgnoreCase(name)) {
                        relatedReponse.setTop(top);
                    }
                }
            }
            searchRelatedReponses.add(new SearchRelatedReponse(keySearchs.get(i), relatedReponses));
        }
        return searchRelatedReponses;
    }

    public List<SearchRelatedTopicReponse> SetSearchRelatedTopic(String inputString) {
        List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();

        inputString = inputString.replace(SearchRelatedTopicRequest.class.getSimpleName(), "");

        JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(0)).getAsJsonObject().get("rising");
        JsonArray jsonArray = (JsonArray) jsonObject.get("data");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray item = (JsonArray) jsonArray.get(i);
            String rising = item.get(0).toString();
            String name = item.get(4).toString();
            searchRelatedTopicReponses.add(new SearchRelatedTopicReponse(name, rising));
        }
        jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(0)).getAsJsonObject().get("top");
        jsonArray = (JsonArray) jsonObject.get("data");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray item = (JsonArray) jsonArray.get(i);
            String top = item.get(0).toString();
            String name = item.get(5).toString();
            
            for (SearchRelatedTopicReponse searchRelatedTopicReponse : searchRelatedTopicReponses) {
                if (searchRelatedTopicReponse.getName().equalsIgnoreCase(name)) {
                    searchRelatedTopicReponse.setTop(top);
                }
            }
        }
        return searchRelatedTopicReponses;
    }

    public List<RelatedTopicReponse> SetRelatedTopic(String inputString) {
        List<RelatedTopicReponse> relatedTopicReponses = new ArrayList<>();

        inputString = inputString.replace(RelatedTopicRequest.class.getSimpleName(), "");
        JsonArray jsonArray = new JsonParser().parse(inputString).getAsJsonArray();
        for (int i = 1; i < jsonArray.size(); i++) {
            String title, url, image, description;

            if (!jsonArray.get(i).getAsJsonObject().get("og:title").toString().isEmpty()) {
                title = jsonArray.get(i).getAsJsonObject().get("og:title").toString();
            } else {
                title = "";
            }
            if (!jsonArray.get(i).getAsJsonObject().get("og:url").toString().isEmpty()) {
                url = jsonArray.get(i).getAsJsonObject().get("og:url").toString();
            } else {
                url = "";
            }
            if (!jsonArray.get(i).getAsJsonObject().get("og:image").toString().isEmpty()) {
                image = jsonArray.get(i).getAsJsonObject().get("og:image").toString();
            } else {
                image = "";
            }
            if (!jsonArray.get(i).getAsJsonObject().get("og:description").toString().isEmpty()) {
                description = jsonArray.get(i).getAsJsonObject().get("og:description").toString();
            } else {
                description = "";
            }

            relatedTopicReponses.add(new RelatedTopicReponse(image, title, url, description));
        }
        return relatedTopicReponses;
    }

}
