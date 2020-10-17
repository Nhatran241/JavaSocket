package library.model;

import java.util.List;

public class Category {
    private String name;
    private String id;
    private List<Category> subList;

    public Category(String name, String id, List<Category> subList) {
        this.name = name;
        this.id = id;
        this.subList = subList;
    }
    public Category(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "categoryName='" + name + '\'' +
                ", categoryCode='" + id + '\'' +
                '}';
    }
}
