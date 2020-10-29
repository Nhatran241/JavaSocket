package javalibrary.model.request;

public abstract class BaseRequest {
    private Long timestamp= System.currentTimeMillis();
    private String requestType;

    public BaseRequest(){
        requestType = setRequestType();
    }
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public abstract String setRequestType();
}
