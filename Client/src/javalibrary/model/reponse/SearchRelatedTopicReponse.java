package javalibrary.model.reponse;

import java.util.ArrayList;
import java.util.List;

public class SearchRelatedTopicReponse {
    List<RelatedTopicRising> relatedTopicRisings = new ArrayList<>();
    List<RelatedTopicTop> relatedTopicTops = new ArrayList<>();

    public SearchRelatedTopicReponse() {
    
    }
    
    public SearchRelatedTopicReponse(List<RelatedTopicRising> relatedTopicRisings ,List<RelatedTopicTop> relatedTopicTops) {
        this.relatedTopicRisings = relatedTopicRisings;
        this.relatedTopicTops = relatedTopicTops;
    }
  
    public List<RelatedTopicRising> getRelatedTopicRisings() {
        return relatedTopicRisings;
    }

    public void setRelatedTopicRisings(List<RelatedTopicRising> relatedTopicRisings) {
        this.relatedTopicRisings = relatedTopicRisings;
    }

    public List<RelatedTopicTop> getRelatedTopicTops() {
        return relatedTopicTops;
    }

    public void setRelatedTopicTops(List<RelatedTopicTop> relatedTopicTops) {
        this.relatedTopicTops = relatedTopicTops;
    }

}
