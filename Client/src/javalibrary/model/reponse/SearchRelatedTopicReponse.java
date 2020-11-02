package javalibrary.model.reponse;

public class SearchRelatedTopicReponse {
    String name, top, rising;
    
    public SearchRelatedTopicReponse() {
        
    }

    public SearchRelatedTopicReponse(String name, String rising) {
        this.name = name;
        this.rising = rising;
    }

    public SearchRelatedTopicReponse(String name, String top, String rising) {
        this.name = name;
        this.top = top;
        this.rising = rising;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    
}
