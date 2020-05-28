package com.example.hp.myapplication.entity;

public class Item {

    private int iTime;
    private String iName;

    public Item() {
    }

    public Item(int iTime, String iName) {
        this.iTime = iTime;
        this.iName = iName;
    }

    public int getiTime() {
        return iTime;
    }

    public void setiTime(int iTime) {
        this.iTime = iTime;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
