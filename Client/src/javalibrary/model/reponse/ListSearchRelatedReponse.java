/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary.model.reponse;

/**
 *
 * @author phung
 */
public class ListSearchRelatedReponse {
    String column;
    SearchRelatedReponse searchRelatedReponse;

    public ListSearchRelatedReponse(String column, SearchRelatedReponse searchRelatedReponse) {
        this.column = column;
        this.searchRelatedReponse = searchRelatedReponse;
    }

    public String getColumn() {
        return column;
    }

    public ListSearchRelatedReponse() {
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public SearchRelatedReponse getSearchRelatedReponse() {
        return searchRelatedReponse;
    }

    public void setSearchRelatedReponse(SearchRelatedReponse searchRelatedReponse) {
        this.searchRelatedReponse = searchRelatedReponse;
    }
    
}
