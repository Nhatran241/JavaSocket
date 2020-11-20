package javalibrary.model.reponse;

import java.util.List;

public class SearchOverTimeReponse {

    List<Long> index;
    List<OverTimeReponse> overTimeReponses;

    public SearchOverTimeReponse() {
    }

    public SearchOverTimeReponse(List<Long> index, List<OverTimeReponse> overTimeReponses) {
        this.index = index;
        this.overTimeReponses = overTimeReponses;
    }

    public List<Long> getIndex() {
        return index;
    }

    public void setIndex(List<Long> index) {
        this.index = index;
    }

    public List<OverTimeReponse> getOverTimeReponses() {
        return overTimeReponses;
    }

    public void setOverTimeReponses(List<OverTimeReponse> overTimeReponses) {
        this.overTimeReponses = overTimeReponses;
    }

}
