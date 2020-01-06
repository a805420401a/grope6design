package com.grope6.design.entity;

import java.util.Date;

public class Indentitem {
    private String indentitemid;

    private String buyerid;

    private String goodsid;

    private double price;

    private Integer number;

    private String indentdatetime;

    private boolean paystate;

    private boolean finishstate;

    public Indentitem(String indentitemid, String buyerid, String goodsid, double price, Integer number, String indentdatetime, boolean paystate, boolean finishstate) {
        this.indentitemid = indentitemid;
        this.buyerid = buyerid;
        this.goodsid = goodsid;
        this.price = price;
        this.number = number;
        this.indentdatetime = indentdatetime;
        this.paystate = paystate;
        this.finishstate = finishstate;
    }

    public Indentitem() {
    }

    public String getIndentitemid() {
        return indentitemid;
    }

    public void setIndentitemid(String indentitemid) {
        this.indentitemid = indentitemid;
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIndentdatetime() {
        return indentdatetime;
    }

    public void setIndentdatetime(String indentdatetime) {
        this.indentdatetime = indentdatetime;
    }

    public boolean isPaystate() {
        return paystate;
    }

    public void setPaystate(boolean paystate) {
        this.paystate = paystate;
    }

    public boolean isFinishstate() {
        return finishstate;
    }

    public void setFinishstate(boolean finishstate) {
        this.finishstate = finishstate;
    }
}