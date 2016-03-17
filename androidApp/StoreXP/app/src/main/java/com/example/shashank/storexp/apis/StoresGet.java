package com.example.shashank.storexp.apis;

import android.graphics.Bitmap;

import java.lang.reflect.Array;

/**
 * Created by shashank on 3/9/15.
 */
public class StoresGet {
    private String storename;
    private Bitmap storepic;
    private Integer points;
    private String membership;


    public String getStorename() {return storename;}
    public void setStorename(String storename) {this.storename = storename;}

    public Integer getPoints() {return points;}
    public void setPoints(Integer points) {
        this.points = points;
    }

    public Bitmap getStorepic () {
        return storepic;
    }
    public void setStorepic(Bitmap storepic) {
        this.storepic = storepic;
    }

    public String getMembership() {return membership;}
    public void setMembership(String membership) {this.membership = membership;}


}
