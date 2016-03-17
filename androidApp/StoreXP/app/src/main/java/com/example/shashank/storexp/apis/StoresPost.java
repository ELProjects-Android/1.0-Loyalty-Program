package com.example.shashank.storexp.apis;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

/**
 * Created by shashank on 3/9/15.
 */
public class StoresPost {

        @SerializedName("storename")
        private String lstorename;
    public String getStorenname() {return lstorename;}
    public void setStorename(String lstorename) {this.lstorename = lstorename;}

        @SerializedName("store_pic")
    private Bitmap lstore_pic;
    public Bitmap getStore_pic() {return lstore_pic;}
    public void setStore_pic(Bitmap lstore_pic) {this.lstore_pic = lstore_pic;}

        @SerializedName("membership")
        private String lmembership;
    public String getMenbership() {return lmembership;}
    public void setmMembership(String lmembership) {this.lmembership = lmembership;}

        @SerializedName("points")
        private Integer lpoints;
    public Integer getPoints() {return lpoints;}
    public void setPoints(Integer lpoints) {this.lpoints = lpoints;}


}
