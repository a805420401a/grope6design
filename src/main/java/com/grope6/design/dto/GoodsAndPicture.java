package com.grope6.design.dto;

import com.grope6.design.entity.Goods;

import java.util.Date;

public class GoodsAndPicture extends Goods {
    String picturepath;

    public GoodsAndPicture(String goodsid, String merchantid, String name, int number, double price, double discount, String description, Date manufacturedate, String manufacturer, int durableyears, String picturepath) {
        super(goodsid, merchantid, name, number, price, discount, description, manufacturedate, manufacturer, durableyears);
        this.picturepath = picturepath;
    }

    public GoodsAndPicture() {
    }

    public String getPicture() {
        return picturepath;
    }

    public void setPicture(String picturepath) {
        this.picturepath = picturepath;
    }
}
