package library.model;

import java.util.List;

public class Geo {
    private String geoName;
    private String geoCode;
    private List<Geo> subList;

    public Geo(String geoName, String geoCode,List<Geo> subList) {
        this.geoName = geoName;
        this.geoCode = geoCode;
        this.subList = subList;
    }

    public Geo(String geoName, String geoCode) {
        this.geoName = geoName;
        this.geoCode = geoCode;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public String getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
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
                "geoName='" + geoName + '\'' +
                ", geoCode='" + geoCode + '\'' +
                '}';
    }
}
