package library.model.request;

import library.model.Category;
import library.model.Geo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchRequest extends BaseRequest{
    private String searchQuery;
    private Geo geo;
    private Category category;
    private String fromDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    private String toDate =  new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    public SearchRequest() {
        super();
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
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
                "searchQuery='" + searchQuery + '\'' +
                ", geo=" + geo +
                ", category=" + category +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    @Override
    public String setRequestType() {
        return this.getClass().getSimpleName();
    }
}
