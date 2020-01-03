package com.grope6.design.service;

import com.grope6.design.entity.Login;
import com.grope6.design.entity.Merchant;

import java.util.List;

public interface MerchantService {
    //查询所有
    List<Merchant> findAll();

    //更新
    int updateMerchant(Merchant merchant);

    //插入
    int insertMerchant(Merchant merchant);

    //根据id查询
    Merchant findByUserId(String merchantId);

    //根据id删除
    int deleteByUserId(String merchantId);
}
