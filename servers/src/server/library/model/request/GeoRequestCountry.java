package server.library.model.request;

public class GeoRequestCountry extends BaseRequest {
    @Override
    public String setRequestType() {
        return this.getClass().getName();
    }
}
