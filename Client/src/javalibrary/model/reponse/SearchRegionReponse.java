package javalibrary.model.reponse;

import java.util.List;

public class SearchRegionReponse {
    String column;
    List<RegionReponse> regionReponses;

    public SearchRegionReponse() {
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public List<RegionReponse> getRegionReponses() {
        return regionReponses;
    }

    public void setRegionReponses(List<RegionReponse> regionReponses) {
        this.regionReponses = regionReponses;
    }

    public SearchRegionReponse(String column, List<RegionReponse> regionReponses) {
        this.column = column;
        this.regionReponses = regionReponses;
    }

    
    
}
