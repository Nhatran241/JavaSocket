/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary.model.reponse;

import java.util.List;

/**
 *
 * @author trann
 */
public class SuggesstionKeywordResponse {
    List<SuggesstionResponse> response;

    public SuggesstionKeywordResponse() {
    }
    public List<SuggesstionResponse> getResponse(){
        return response;
    }
    public void setResponse(List<SuggesstionResponse> response){
        this.response = response;
    }
    
    
}
