package javalibrary.model.request;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javalibrary.model.Category;
import javalibrary.model.Geo;

import java.util.List;

public class SearchOvertimeRequest extends BaseRequest{
    private List<String> searchQuery;
    private Geo geo;
    private Category category;
    private String fromDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    private String toDate =  new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    public SearchOvertimeRequest() {
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
        return "SearchOvertimeRequest{" +
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
