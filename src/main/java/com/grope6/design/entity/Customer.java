package com.grope6.design.entity;

public class Customer {
    private String buyerid;

    private String name;

    private String phone;

    private String address;

    public Customer(String buyerid, String name, String phone, String address) {
        this.buyerid = buyerid;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer() {
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}