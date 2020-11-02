package javalibrary.model.reponse;

import java.util.List;

public class SearchRelatedReponse {
    String colunm;
    List<RelatedReponse> relatedReponses;

    public SearchRelatedReponse() {
    }

    public String getColunm() {
        return colunm;
    }

    public void setColunm(String colunm) {
        this.colunm = colunm;
    }

    public List<RelatedReponse> getRelatedReponses() {
        return relatedReponses;
    }

    public void setRelatedReponses(List<RelatedReponse> relatedReponses) {
        this.relatedReponses = relatedReponses;
    }

    public SearchRelatedReponse(String colunm, List<RelatedReponse> relatedReponses) {
        this.colunm = colunm;
        this.relatedReponses = relatedReponses;
    }
}
