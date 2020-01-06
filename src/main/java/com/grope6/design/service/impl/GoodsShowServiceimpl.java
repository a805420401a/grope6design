package com.grope6.design.service.impl;

import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;
import com.grope6.design.mapper.GoodsshowMapper;
import com.grope6.design.service.GoodsShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsShowServiceimpl implements GoodsShowService {

    @Autowired
    GoodsshowMapper goodsshowMapper;

    @Override
    public List<Goodsshow> findAll() {
        return goodsshowMapper.findAll();
    }

    @Override
    public int updateGoodsshow(Goodsshow goodsshow) {
        return goodsshowMapper.update(goodsshow);
    }

    @Override
    public int insertGoods(Goodsshow goodsshow) {
        return goodsshowMapper.insert(goodsshow);
    }

    @Override
    public Goodsshow findByGoodsid(String goodsid) {
        return goodsshowMapper.findByGoodsid(goodsid);
    }

    @Override
    public int deleteByGoodsId(String goodsId) {
        return goodsshowMapper.deleteByGoodsId(goodsId);
    }
}
