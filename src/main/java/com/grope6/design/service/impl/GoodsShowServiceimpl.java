package com.grope6.design.service.impl;

import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.mapper.GoodsshowMapper;
import com.grope6.design.service.GoodsShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsShowServiceimpl implements GoodsShowService {

    @Autowired
    GoodsshowMapper goodsshowMapper;

    @Override
    public int updateGoods(Goodsshow login) {
        return 0;
    }

    @Override
    public int insertGoods(Goodsshow login) {
        return goodsshowMapper.insert(login);
    }

    @Override
    public Goodsshow findByGoodsid(String Goodsid) {
        return null;
    }

    @Override
    public int deleteByGoodsId(Goodsshow goodsId) {
        return 0;
    }
}
