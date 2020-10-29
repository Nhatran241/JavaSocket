/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Interfaces;

import java.util.List;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.reponse.SearchReponse;

/**
 *
 * @author phung
 */
public class Interfaces {
    public interface IConnectListener {

        void onConnectSuccess();

        void onConnectFailed();

        void onDisconnect();

    }

    public interface IGetGeoListener {

        void onGetGeoSuccess(List<Geo> geo);

        void onGetGeoFailed();
    }

    public interface IGetCategoryListener {

        void onGetCategorySuccess(List<Category> categorys);

        void onGetCategoryFailed();
    }

    public interface IGetSearchRegionListener {

        void OnGetSearchRegionSuccess(List<SearchRegionReponse> searchRegionReponses);

        void OnGetSearchRegionFailed();
    }
    
    public interface ISearchRelatedListener {
        void OnGetSearchRelatedSuccess(List<SearchRelatedReponse> searchRelatedReponses);

        void OnGetSearchRelatedFailed();
    }
    
    public interface ISearchRelatedTopicListener {
        void OnGetSearchRelatedTopicSuccess(List<SearchRelatedTopicReponse> searchRelatedTopicReponses);
        
        void OnGetSearchRelatedTopicFailed();
    }
    
    public interface IRelatedTopicListener {
        void OnGetRelatedTopicSuccess(List<RelatedTopicReponse> relatedTopicReponses);
        
        void OnGetRelatedTopicFailed();
    }
    
    public interface ISearchListener {
        void OnGetSearchSuccess(List<SearchReponse> searchReponses);
        
        void OnGetSearchFailed();
    }
}
