package client;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.util.ArrayList;
import java.util.List;
import javalibrary.model.Geo;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;

public class Data {

    private static Data instance;
    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }
    
    MyClient myClient = MyClient.getInstance();
    
    public Data() {
        myClient.connect(new Interfaces.IConnectListener() {
            @Override
            public void onConnectSuccess() {
            }

            @Override
            public void onConnectFailed() {
            }

            @Override
            public void onDisconnect() {
            }
        });
    }

    public List<Geo> getGeosView() {
        List<Geo> geos = new ArrayList<>();

        myClient.getGeo(new Interfaces.IGetGeoListener() {
            @Override
            public void onGetGeoSuccess(List<Geo> geo) {
                geos.addAll(geo);
                System.out.println("data: " + geo);
            }

            @Override
            public void onGetGeoFailed() {
            }
        });

        return geos;
    }

    public List<SearchRegionReponse> getSearchRegionView(SearchRegionRequest searchRegionRequest) {
        List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();

        myClient.getSearchRegion(searchRegionRequest, new Interfaces.IGetSearchRegionListener() {
            @Override
            public void OnGetSearchRegionSuccess(List<SearchRegionReponse> searchRegionReponses) {
                searchRegionReponses.addAll(searchRegionReponses);
            }

            @Override
            public void OnGetSearchRegionFailed() {
            }
        });

        return searchRegionReponses;
    }

    public List<SearchRelatedReponse> getSearchRelatedView(SearchRelatedQueryRequest searchRelatedRequest) {
        List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();

        myClient.getSearchRelated(searchRelatedRequest, new Interfaces.ISearchRelatedListener() {
            @Override
            public void OnGetSearchRelatedSuccess(List<SearchRelatedReponse> searchRelatedReponses) {
                searchRelatedReponses.addAll(searchRelatedReponses);
            }

            @Override
            public void OnGetSearchRelatedFailed() {
            }
        });

        return searchRelatedReponses;
    }

    public List<SearchRelatedTopicReponse> getSearchRelatedTopicView(SearchRelatedTopicRequest searchRelatedTopicRequest) {
        List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();

        myClient.getSearchRelatedTopic(searchRelatedTopicRequest, new Interfaces.ISearchRelatedTopicListener() {
            @Override
            public void OnGetSearchRelatedTopicSuccess(List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
                searchRelatedTopicReponses.addAll(searchRelatedTopicReponses);
            }

            @Override
            public void OnGetSearchRelatedTopicFailed() {
            }
        });

        return searchRelatedTopicReponses;
    }

    public List<RelatedTopicReponse> getRelatedTopic(RelatedTopicRequest relatedTopicRequest) {
        List<RelatedTopicReponse> relatedTopicReponses = new ArrayList<>();
        myClient.getRelatedTopic(relatedTopicRequest, new Interfaces.IRelatedTopicListener() {
            @Override
            public void OnGetRelatedTopicSuccess(List<RelatedTopicReponse> relatedTopicReponses) {
                relatedTopicReponses.addAll(relatedTopicReponses);
            }

            @Override
            public void OnGetRelatedTopicFailed() {
            }
        });

        return relatedTopicReponses;
    }
}
