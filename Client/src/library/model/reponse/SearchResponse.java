package library.model.reponse;

import java.util.List;

public class SearchResponse extends BaseResponse {
    private List<String> relatedKeyword;

    public SearchResponse(int responseCode) {
        super(responseCode);
    }

    @Override
    protected String setResponseType() {
        return this.getClass().getName();
    }

    public List<String> getRelatedKeyword() {
        return relatedKeyword;
    }

    public void setRelatedKeyword(List<String> relatedKeyword) {
        this.relatedKeyword = relatedKeyword;
    }


}
