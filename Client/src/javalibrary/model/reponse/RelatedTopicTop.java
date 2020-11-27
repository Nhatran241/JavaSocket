package javalibrary.model.reponse;

public class RelatedTopicTop {
    String name, top;

    public RelatedTopicTop() {
    }

    public RelatedTopicTop(String name, String top) {
        this.name = name;
        this.top = top;
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
    
}
