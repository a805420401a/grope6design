package com.grope6.design.entity;

public class Cartitem {

    private String cartitemid;

    private String buyerid;

    private String goodsid;

    private int goodsnumber;

    private double totalprice;

    public Cartitem(String cartitemid, String buyerid, String goodsid, int goodsnumber, double totalprice) {
        this.cartitemid = cartitemid;
        this.buyerid = buyerid;
        this.goodsid = goodsid;
        this.goodsnumber = goodsnumber;
        this.totalprice = totalprice;
    }

    public Cartitem() {
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(String cartitemid) {
        this.cartitemid = cartitemid;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
}