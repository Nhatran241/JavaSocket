package library.model.reponse;

import java.util.List;

public class SearchResponse extends BaseResponse {
    private List<String> relatedKeyword;

    public SearchResponse(int responseCode) {
        super(responseCode);
    }

    public List<String> getRelatedKeyword() {
        return relatedKeyword;
    }

    public void setRelatedKeyword(List<String> relatedKeyword) {
        this.relatedKeyword = relatedKeyword;
    }

    @Override
    protected String setResponseType() {
        return this.getClass().getName();
    }
}
