package com.grope6.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grope6.design.dto.GoodsQryItem;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.Login;
import com.grope6.design.mapper.GoodsMapper;
import com.grope6.design.mapper.LoginMapper;
import com.grope6.design.service.GoodsService;
import com.grope6.design.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        return null;
    }

    @Override
    public PageInfo<Goods> jwcCourseinfoSelect(String merchantid, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> courseQryResults = goodsMapper.GoodsinfoSelect(merchantid);

        //用PageInfo对结果进行包装
        PageInfo<Goods> page = new PageInfo<>(courseQryResults);
        return page;
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    @Override
    public Goods findByGoodsId(String goodsId) {
        return goodsMapper.findByGoodsId(goodsId);
    }

    @Override
    public int insertGoods(Goods login) {
        return goodsMapper.insert(login);
    }

    @Override
    public int deleteByGoodsId(String goodsId) {
        return goodsMapper.deleteByPrimaryKey(goodsId);
    }
}
