package com.example.myandroidproject;

public class SingerItem {

    private String item;
    private String mobile;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "SingerItem{" +
                "item='" + item + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }



}
