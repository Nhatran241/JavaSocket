/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibrary.model;

/**
 *
 * @author phung
 */
public class ComboItem {
    private String value, lable;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public ComboItem() {
    }

    public ComboItem(String value, String lable) {
        this.value = value;
        this.lable = lable;
    }
    
}
