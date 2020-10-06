package library.model.request;

public class RelatedTopicRequest extends BaseRequest {
    @Override
    public String setRequestType() {
        return this.getClass().getName();
    }
}
