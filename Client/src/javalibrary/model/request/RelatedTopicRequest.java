package javalibrary.model.request;

public class RelatedTopicRequest extends BaseRequest {
    public static String apiKeyGoogle = "AIzaSyByAfwF3d7h79pzRcxiz8c6fqW-0PK6Avo";
    public static String idSearchEngine = "e34885c89b9f0563b";

    private String relatedTopicQuery;
    private int pageNumber;

    public RelatedTopicRequest(){
        super();
        pageNumber = 0;
    }

    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }

    public String getRelatedTopicQuery() {
        return relatedTopicQuery;
    }

    public void setRelatedTopicQuery(String relatedTopicQuery) {
        this.relatedTopicQuery = relatedTopicQuery;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "RelatedTopicRequest{" +
                "relatedTopicQuery='" + relatedTopicQuery + '\'' +
                ","+idSearchEngine+
                ","+apiKeyGoogle+
                ","+pageNumber+
                '}';
    }
}

