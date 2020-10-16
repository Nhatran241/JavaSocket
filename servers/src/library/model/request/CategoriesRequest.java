package library.model.request;

public class CategoriesRequest extends BaseRequest {
    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }
}
