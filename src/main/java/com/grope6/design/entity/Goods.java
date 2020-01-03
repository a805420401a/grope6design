package com.grope6.design.entity;

import java.util.Date;

public class Goods {
    private String goodsid;

    private String merchantid;

    private String name;

    private int number;

    private double price;

    private double discount;

    private String description;

    private Date manufacturedate;

    private String manufacturer;

    private int durableyears;

    public Goods(String goodsid, String merchantid, String name, int number, double price, double discount, String description, Date manufacturedate, String manufacturer, int durableyears) {
        this.goodsid = goodsid;
        this.merchantid = merchantid;
        this.name = name;
        this.number = number;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.manufacturedate = manufacturedate;
        this.manufacturer = manufacturer;
        this.durableyears = durableyears;
    }

    public Goods(){

    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getManufacturedate() {
        return manufacturedate;
    }

    public void setManufacturedate(Date manufacturedate) {
        this.manufacturedate = manufacturedate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDurableyears() {
        return durableyears;
    }

    public void setDurableyears(int durableyears) {
        this.durableyears = durableyears;
    }
}