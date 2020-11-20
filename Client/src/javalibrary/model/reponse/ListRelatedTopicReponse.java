package javalibrary.model.reponse;

import java.util.List;

public class ListRelatedTopicReponse {
    List<RelatedTopicReponse> relatedTopicReponses;
    String column;

    public ListRelatedTopicReponse(List<RelatedTopicReponse> relatedTopicReponses, String column) {
        this.relatedTopicReponses = relatedTopicReponses;
        this.column = column;
    }

    public ListRelatedTopicReponse() {
    }

    public List<RelatedTopicReponse> getRelatedTopicReponses() {
        return relatedTopicReponses;
    }

    public void setRelatedTopicReponses(List<RelatedTopicReponse> relatedTopicReponses) {
        this.relatedTopicReponses = relatedTopicReponses;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
    
}
