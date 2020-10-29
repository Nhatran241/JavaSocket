package Services;

import Services.Interfaces.Interfaces.IConnectListener;
import Services.Interfaces.Interfaces.IGetCategoryListener;
import Services.Interfaces.Interfaces.IGetGeoListener;
import Services.Interfaces.Interfaces.IGetSearchRegionListener;
import Services.Interfaces.Interfaces.IRelatedTopicListener;
import Services.Interfaces.Interfaces.ISearchListener;
import Services.Interfaces.Interfaces.ISearchRelatedListener;
import Services.Interfaces.Interfaces.ISearchRelatedTopicListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javalibrary.SocketTransceiver;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.reponse.ListSearchRegionReponse;
import javalibrary.model.reponse.ListSearchRelatedReponse;
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
    private ISearchListener iSearchListener;

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

    public List<Geo> SetGeo(String inpuString) {
        inpuString = inpuString.replace(GeoRequestCountry.class.getSimpleName(), "");
        List<Geo> geos = new ArrayList<>();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Type collectionType = new TypeToken<List<Geo>>() {
        }.getType();
        geos = gson.fromJson(inpuString, collectionType);

        return geos;
    }

    public List<Category> SetCategoryrecursive(String inputString) {
        List<Category> categorys = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(inputString).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {

            String id = jsonArray.get(i).getAsJsonObject().get("id").toString();
            String name = jsonArray.get(i).getAsJsonObject().get("name").toString();

            if (jsonArray.get(i).getAsJsonObject().get("children") != null) {
                String children = jsonArray.get(i).getAsJsonObject().get("children").toString();
                Category category = new Category(name, id, SetCategoryrecursive(children));
                categorys.add(category);
            } else {
                Category category = new Category(name, id);
                categorys.add(category);
            }
        }
        return categorys;
    }

    public List<ListSearchRegionReponse> SetSearchRegion(String inputString) {
        inputString = inputString.replace(SearchRegionRequest.class.getSimpleName(), "");
        List<ListSearchRegionReponse> listSearchRegionReponses = new ArrayList<>();
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject();

        for (int i = 0; i < keySearchs.size(); i++) {
            SearchRegionReponse searchRegionReponse = new SearchRegionReponse();

            JsonArray dataArray = (JsonArray) jsonObject.get("data");
            JsonArray indexArray = (JsonArray) jsonObject.get("index");
            for (int j = 0; j < indexArray.size(); j++) {

                String name = indexArray.get(j).toString();
                JsonArray item = (JsonArray) dataArray.get(j);
                String total = item.get(i).toString();

                searchRegionReponse.setName(name);
                searchRegionReponse.setTotal(total);
            }
            ListSearchRegionReponse listSearchRegionReponse = new ListSearchRegionReponse(keySearchs.get(i), searchRegionReponse);
            listSearchRegionReponses.add(listSearchRegionReponse);
        }
        return listSearchRegionReponses;
    }

    public List<ListSearchRelatedReponse> SetSearchRelated(String inputString) {
        List<ListSearchRelatedReponse> listSearchRelatedReponses = new ArrayList<>();

        inputString = inputString.replace(SearchRelatedQueryRequest.class.getSimpleName(), "");
        System.out.println("input String: " + inputString);

        for (int i = 0; i < keySearchs.size(); i++) {
            SearchRelatedReponse searchRelatedReponse = new SearchRelatedReponse();

            JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(i)).getAsJsonObject().get("rising");
            JsonArray jsonArray = (JsonArray) jsonObject.get("data");
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonArray item = (JsonArray) jsonArray.get(j);
                
                String name = item.get(0).toString();
                String total = item.get(1).toString();

                System.out.println("item: " + name + total);

                searchRelatedReponse.setName(name);
                searchRelatedReponse.setTotal(total);
            }
            ListSearchRelatedReponse listSearchRelatedReponse = new ListSearchRelatedReponse(keySearchs.get(i), searchRelatedReponse);
            listSearchRelatedReponses.add(listSearchRelatedReponse);
        }

        return listSearchRelatedReponses;
    }

    public List<SearchRelatedTopicReponse> SetSearchRelatedTopic(String inputString) {
        List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();

        inputString = inputString.replace(SearchRelatedTopicRequest.class.getSimpleName(), "");

        JsonObject jsonObject = (JsonObject) new JsonParser().parse(inputString).getAsJsonObject().get(keySearchs.get(0)).getAsJsonObject().get("rising");
        JsonArray jsonArray = (JsonArray) jsonObject.get("data");
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray item = (JsonArray) jsonArray.get(i);
            String total = item.get(0).toString();
            String name = item.get(4).toString();
            SearchRelatedTopicReponse searchRelatedTopicReponse = new SearchRelatedTopicReponse(name, total);
            searchRelatedTopicReponses.add(searchRelatedTopicReponse);
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

            RelatedTopicReponse relatedTopicReponse = new RelatedTopicReponse(image, title, url, description);
            relatedTopicReponses.add(relatedTopicReponse);
        }
        return relatedTopicReponses;
    }

}
