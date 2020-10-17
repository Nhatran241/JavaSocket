package library.model;

import java.util.List;

public class Geo {
    private String name;
    private String id;
    private List<Geo> subList;

    public Geo(String name, String id, List<Geo> subList) {
        this.name = name;
        this.id = id;
        this.subList = subList;
    }

    public Geo(String name, String id) {
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

    public List<Geo> getSubList() {
        return subList;
    }

    public void setSubList(List<Geo> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", subList=" + subList +
                '}';
    }
}
