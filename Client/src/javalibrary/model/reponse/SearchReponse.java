/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary.model.reponse;

import java.util.List;

/**
 *
 * @author phung
 */
public class SearchReponse {
    String column;
    List<SearchRegionReponse> searchRegionReponses;
    List<SearchRelatedReponse> searchRelatedReponses;
    List<SearchRelatedTopicReponse> searchRelatedTopicReponses;
    
    public SearchReponse() {
        
    }
    
    public SearchReponse(String column, List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses, List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        this.column = column;
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        this.searchRelatedTopicReponses = searchRelatedTopicReponses;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public List<SearchRegionReponse> getSearchRegionReponses() {
        return searchRegionReponses;
    }

    public void setSearchRegionReponses(List<SearchRegionReponse> searchRegionReponses) {
        this.searchRegionReponses = searchRegionReponses;
    }

    public List<SearchRelatedReponse> getSearchRelatedReponses() {
        return searchRelatedReponses;
    }

    public void setSearchRelatedReponses(List<SearchRelatedReponse> searchRelatedReponses) {
        this.searchRelatedReponses = searchRelatedReponses;
    }

    public List<SearchRelatedTopicReponse> getSearchRelatedTopicReponses() {
        return searchRelatedTopicReponses;
    }

    public void setSearchRelatedTopicReponses(List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        this.searchRelatedTopicReponses = searchRelatedTopicReponses;
    }
    
    
}
