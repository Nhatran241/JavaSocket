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
public class SearchRelatedTopicReponse {
    String name, total;
    
    public SearchRelatedTopicReponse() {
        
    }
    
    public SearchRelatedTopicReponse(String name, String total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
