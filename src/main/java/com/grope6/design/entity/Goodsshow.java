package com.grope6.design.entity;

public class Goodsshow {
    private String goodsid;

    private String picturepath;

    public Goodsshow(String goodsid, String picturepath) {
        this.goodsid = goodsid;
        this.picturepath = picturepath;
    }

    public Goodsshow() {
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }
}