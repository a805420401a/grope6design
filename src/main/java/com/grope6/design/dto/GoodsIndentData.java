package com.grope6.design.dto;

import com.grope6.design.entity.Indentitem;

public class GoodsIndentData {
    private String goodsindentitemid;
    private String goodspicture;
    private String goodsName;
    private double goodsPrice;
    private int goodsNumber;
    private double goodsTotalPrice;
    private String Datetime;
    private String goodsPayState;
    private String goodsFinishState;

    public GoodsIndentData(String goodsindentitemid, String goodspicture, String goodsName, double goodsPrice, int goodsNumber, double goodsTotalPrice, String datetime, String goodsPayState, String goodsFinishState) {
        this.goodsindentitemid = goodsindentitemid;
        this.goodspicture = goodspicture;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
        this.goodsTotalPrice = goodsTotalPrice;
        Datetime = datetime;
        this.goodsPayState = goodsPayState;
        this.goodsFinishState = goodsFinishState;
    }

    public GoodsIndentData() {
    }

    public String getGoodsindentitemid() {
        return goodsindentitemid;
    }

    public void setGoodsindentitemid(String goodsindentitemid) {
        this.goodsindentitemid = goodsindentitemid;
    }

    public String getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public String getGoodsPayState() {
        return goodsPayState;
    }

    public void setGoodsPayState(String goodsPayState) {
        this.goodsPayState = goodsPayState;
    }

    public String getGoodsFinishState() {
        return goodsFinishState;
    }

    public void setGoodsFinishState(String goodsFinishState) {
        this.goodsFinishState = goodsFinishState;
    }
}
