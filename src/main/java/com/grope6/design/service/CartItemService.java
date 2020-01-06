package com.grope6.design.service;

import com.grope6.design.entity.Cartitem;
import com.grope6.design.entity.Merchant;

import java.util.List;

public interface CartItemService {
    //查询所有
    List<Cartitem> findAll();

    //更新
    int updateCartItem(Cartitem cartitem);

    //插入
    int insertCartItem(Cartitem cartitem);

    //根据id查询
    Cartitem findByUserId(String cartitemId);

    //根据id删除
    int deleteByUserId(String cartitemId);

    Cartitem findByGoodsId( String goodsid );

    int updateCartItemAddNumber(String goodsid, int number);

    int updateCartItemAddTotalPrice(String goodsid, double totalPrice);

    List<Cartitem> findAllByUserId(String buyerid);

    int deleteByGoodsCartItemId(String goodsCartItemId);
}
