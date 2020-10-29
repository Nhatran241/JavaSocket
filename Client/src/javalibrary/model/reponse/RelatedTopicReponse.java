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
public class RelatedTopicReponse {
    String image, title, url, description;
    public RelatedTopicReponse() {
        
    }

    public RelatedTopicReponse(String image, String title, String url, String description) {
        this.image = image;
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
