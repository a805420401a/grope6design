package com.grope6.design.service;

import com.github.pagehelper.PageInfo;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Goodsshow;

import java.util.List;

public interface GoodsShowService {

    //更新
    int updateGoods(Goodsshow login);

    //插入
    int insertGoods(Goodsshow login);

    Goodsshow findByGoodsid(String Goodsid);

    //根据id删除
    int deleteByGoodsId(Goodsshow goodsId);
}
