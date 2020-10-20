package javalibrary.model.reponse;

public abstract class BaseResponse {
    private int responseCode;
    private String responseType = setResponseType();

    public BaseResponse(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public static int interruptedException =1;
    public static int ioException =2;
    protected abstract String setResponseType();
}
