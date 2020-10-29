/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary.model.request;

import java.util.List;

/**
 *
 * @author phung
 */
public class SearchRequest {
    List<String> keySearch;
    SearchRegionRequest searchRegionRequest;
    SearchRelatedQueryRequest searchRelatedQueryRequest;
    SearchRelatedTopicRequest searchRelatedTopicRequest;
    
    public SearchRequest() {
        
    }

    public List<String> getKeySearch() {
        return keySearch;
    }

    public void setKeySearch(List<String> keySearch) {
        this.keySearch = keySearch;
    }

    public SearchRegionRequest getSearchRegionRequest() {
        return searchRegionRequest;
    }

    public void setSearchRegionRequest(SearchRegionRequest searchRegionRequest) {
        this.searchRegionRequest = searchRegionRequest;
    }

    public SearchRelatedQueryRequest getSearchRelatedQueryRequest() {
        return searchRelatedQueryRequest;
    }

    public void setSearchRelatedQueryRequest(SearchRelatedQueryRequest searchRelatedQueryRequest) {
        this.searchRelatedQueryRequest = searchRelatedQueryRequest;
    }

    public SearchRelatedTopicRequest getSearchRelatedTopicRequest() {
        return searchRelatedTopicRequest;
    }

    public void setSearchRelatedTopicRequest(SearchRelatedTopicRequest searchRelatedTopicRequest) {
        this.searchRelatedTopicRequest = searchRelatedTopicRequest;
    }
    
    
}
