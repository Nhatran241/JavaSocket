package library.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String id;
    private List<Category> children;

    public Category(String name, String id, List<Category> children) {
        this.name = name;
        this.id = id;
        this.children = children;
    }
    public Category(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public Category() {
        
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

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", id=" + id +
                ", children=" + children +
                "}";
    }
}
