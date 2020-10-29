package javalibrary.model.request;

import javalibrary.model.Category;
import javalibrary.model.Geo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SearchRegionRequest extends BaseRequest{
    private List<String> searchQuery;
    private Geo geo;
    private Category category;
    private String fromDate = "";
    private String toDate = "";

    public SearchRegionRequest() {
        super();
    }

    public List<String> getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(List<String> searchQuery) {
        this.searchQuery = searchQuery;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "searchQuery=" + searchQuery +
                ", geo=" + geo +
                ", category=" + category +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }
}
