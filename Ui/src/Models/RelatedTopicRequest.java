/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class RelatedTopicRequest extends BaseRequest {
    @Override
    public String setRequestType() {
        return this.getClass().getName();
    }
}