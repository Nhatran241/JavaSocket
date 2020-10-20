package library.model.request;

public class GeoRequestCountry extends BaseRequest {
    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }
}
