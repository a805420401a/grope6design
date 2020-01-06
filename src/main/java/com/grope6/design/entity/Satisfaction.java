package com.grope6.design.entity;

public class Satisfaction {
    private String buyerid;

    private String merchantid;

    private double quality;

    private double attitude;

    private double logistics;

    private double synthesize;

    public Satisfaction(String buyerid, String merchantid, double quality, double attitude, double logistics, double synthesize) {
        this.buyerid = buyerid;
        this.merchantid = merchantid;
        this.quality = quality;
        this.attitude = attitude;
        this.logistics = logistics;
        this.synthesize = synthesize;
    }

    public Satisfaction() {
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getAttitude() {
        return attitude;
    }

    public void setAttitude(double attitude) {
        this.attitude = attitude;
    }

    public double getLogistics() {
        return logistics;
    }

    public void setLogistics(double logistics) {
        this.logistics = logistics;
    }

    public double getSynthesize() {
        return synthesize;
    }

    public void setSynthesize(double synthesize) {
        this.synthesize = synthesize;
    }
}