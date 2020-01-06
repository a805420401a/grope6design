package com.grope6.design.dto;

public class GoodsCartData {
    private String goodsCartItemId;
    private String goodspicture;
    private String goodsName;
    private double goodsPrice;
    private double goodsDiscount;
    private int goodsNumber;
    private double goodsTotalPrice;

    public GoodsCartData(String goodsCartItemId, String goodspicture, String goodsName, double goodsPrice, double goodsDiscount, int goodsNumber, double goodsTotalPrice) {
        this.goodsCartItemId = goodsCartItemId;
        this.goodspicture = goodspicture;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDiscount = goodsDiscount;
        this.goodsNumber = goodsNumber;
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public GoodsCartData() {
    }

    public String getGoodsCartItemId() {
        return goodsCartItemId;
    }

    public void setGoodsCartItemId(String goodsCartItemId) {
        this.goodsCartItemId = goodsCartItemId;
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

    public double getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(double goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
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

    @Override
    public String toString() {
        return "GoodsCartData{" +
                "goodspicture='" + goodspicture + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDiscount=" + goodsDiscount +
                ", goodsNumber=" + goodsNumber +
                ", goodsTotalPrice=" + goodsTotalPrice +
                '}';
    }
}
