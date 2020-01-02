package com.grope6.design.dto;

import com.grope6.design.entity.Goods;

public class GoodsQryResult extends Goods {
    String merchantName;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
