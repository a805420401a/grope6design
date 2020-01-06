package com.grope6.design.dto;

public class OrderData {
    private String orderId;
    private String orderBuyerName;
    private String orderBuyerPhone;
    private String orderBuyerAddress;
    private String orderGoodsId;
    private String orderGoodsName;
    private int orderGoodsNumber;
    private double orderGoodsTotalPrice;
    private String orderTime;
    private String orderPayState;
    private String orderShippingStatus;

    public OrderData(String orderId, String orderBuyerName, String orderBuyerPhone, String orderBuyerAddress, String orderGoodsId, String orderGoodsName, int orderGoodsNumber, double orderGoodsTotalPrice, String orderTime, String orderPayState, String orderShippingStatus) {
        this.orderId = orderId;
        this.orderBuyerName = orderBuyerName;
        this.orderBuyerPhone = orderBuyerPhone;
        this.orderBuyerAddress = orderBuyerAddress;
        this.orderGoodsId = orderGoodsId;
        this.orderGoodsName = orderGoodsName;
        this.orderGoodsNumber = orderGoodsNumber;
        this.orderGoodsTotalPrice = orderGoodsTotalPrice;
        this.orderTime = orderTime;
        this.orderPayState = orderPayState;
        this.orderShippingStatus = orderShippingStatus;
    }

    public OrderData() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderBuyerName() {
        return orderBuyerName;
    }

    public void setOrderBuyerName(String orderBuyerName) {
        this.orderBuyerName = orderBuyerName;
    }

    public String getOrderBuyerPhone() {
        return orderBuyerPhone;
    }

    public void setOrderBuyerPhone(String orderBuyerPhone) {
        this.orderBuyerPhone = orderBuyerPhone;
    }

    public String getOrderBuyerAddress() {
        return orderBuyerAddress;
    }

    public void setOrderBuyerAddress(String orderBuyerAddress) {
        this.orderBuyerAddress = orderBuyerAddress;
    }

    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public int getOrderGoodsNumber() {
        return orderGoodsNumber;
    }

    public void setOrderGoodsNumber(int orderGoodsNumber) {
        this.orderGoodsNumber = orderGoodsNumber;
    }

    public double getOrderGoodsTotalPrice() {
        return orderGoodsTotalPrice;
    }

    public void setOrderGoodsTotalPrice(double orderGoodsTotalPrice) {
        this.orderGoodsTotalPrice = orderGoodsTotalPrice;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderPayState() {
        return orderPayState;
    }

    public void setOrderPayState(String orderPayState) {
        this.orderPayState = orderPayState;
    }

    public String getOrderShippingStatus() {
        return orderShippingStatus;
    }

    public void setOrderShippingStatus(String orderShippingStatus) {
        this.orderShippingStatus = orderShippingStatus;
    }
}
