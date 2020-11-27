package javalibrary.model.reponse;

public class RelatedTopicRising {
    String name, rising;

    public RelatedTopicRising() {
    }

    public RelatedTopicRising(String name, String rising) {
        this.name = name;
        this.rising = rising;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }
    
}
