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
public class ListSearchRegionReponse {
    String column;
    SearchRegionReponse searchRegionReponse;

    public ListSearchRegionReponse(String column, SearchRegionReponse searchRegionReponse) {
        this.column = column;
        this.searchRegionReponse = searchRegionReponse;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public ListSearchRegionReponse() {
    }

    public SearchRegionReponse getSearchRegionReponse() {
        return searchRegionReponse;
    }

    public void setSearchRegionReponse(SearchRegionReponse searchRegionReponse) {
        this.searchRegionReponse = searchRegionReponse;
    }
    
}
