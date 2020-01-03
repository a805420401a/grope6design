package com.grope6.design.service;

import com.github.pagehelper.PageInfo;
import com.grope6.design.dto.GoodsQryItem;
import com.grope6.design.entity.Goods;

import java.util.List;

public interface GoodsService {
    //查询所有
    List<Goods> findAll();

    //分页查询
    PageInfo<Goods> jwcCourseinfoSelect(String merchantid ,Integer pageNo, Integer pageSize);

    //更新
    int updateGoods(Goods login);

    Goods findByGoodsId(String goodsId);

    //插入
    int insertGoods(Goods login);

    //根据id删除
    int deleteByGoodsId(String goodsId);
}
