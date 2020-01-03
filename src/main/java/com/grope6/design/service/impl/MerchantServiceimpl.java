package com.grope6.design.service.impl;

import com.grope6.design.entity.Merchant;
import com.grope6.design.mapper.MerchantMapper;
import com.grope6.design.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServiceimpl implements MerchantService {

    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public List<Merchant> findAll() {
        return null;
    }

    @Override
    public int updateMerchant(Merchant merchant) {
        return 0;
    }

    @Override
    public int insertMerchant(Merchant merchant) {
        return merchantMapper.insert(merchant);
    }

    @Override
    public Merchant findByUserId(String merchantId) {
        return merchantMapper.selectByUserId(merchantId);
    }

    @Override
    public int deleteByUserId(String merchantId) {
        return 0;
    }
}
