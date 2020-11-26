package javalibrary.model.request;

public class SuggestionsKeywordRequest extends BaseRequest {
    private String keyword;

    public SuggestionsKeywordRequest() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }
}
