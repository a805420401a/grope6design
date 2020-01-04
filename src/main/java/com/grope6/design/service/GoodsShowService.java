package com.grope6.design.service;

import com.grope6.design.entity.Goodsshow;

import java.util.List;

public interface GoodsShowService {

    List<Goodsshow> findAll();

    //更新
    int updateGoodsshow(Goodsshow goodsshow);

    //插入
    int insertGoods(Goodsshow login);

    Goodsshow findByGoodsid(String goodsid);

    //根据id删除
    int deleteByGoodsId(String goodsId);
}
