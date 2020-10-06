package library.model;

import java.util.List;

public class Category {
    private String categoryName;
    private String categoryCode;
    private List<Category> subList;

    public Category(String categoryName, String categoryCode, List<Category> subList) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.subList = subList;
    }
    public Category(String categoryName, String categoryCode) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public List<Category> getSubList() {
        return subList;
    }

    public void setSubList(List<Category> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                '}';
    }
}
