package com.grope6.design.entity;

public class Merchant {
    private String merchantid;

    private String name;

    private String address;

    private double reputation;

    private String legalperson;

    private double totalassets;

    public Merchant(String merchantid, String name, String address, double reputation, String legalperson, double totalassets) {
        this.merchantid = merchantid;
        this.name = name;
        this.address = address;
        this.reputation = reputation;
        this.legalperson = legalperson;
        this.totalassets = totalassets;
    }

    public Merchant() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getReputation() {
        return reputation;
    }

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public double getTotalassets() {
        return totalassets;
    }

    public void setTotalassets(double totalassets) {
        this.totalassets = totalassets;
    }
}