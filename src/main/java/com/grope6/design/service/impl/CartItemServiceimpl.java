package com.grope6.design.service.impl;

import com.grope6.design.entity.Cartitem;
import com.grope6.design.mapper.CartitemMapper;
import com.grope6.design.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceimpl implements CartItemService {

    @Autowired
    CartitemMapper cartitemMapper;

    @Override
    public List<Cartitem> findAll() {
        return null;
    }

    @Override
    public int updateCartItem(Cartitem cartitem) {
        return 0;
    }

    @Override
    public int insertCartItem(Cartitem cartitem) {
        return cartitemMapper.insert(cartitem);
    }

    @Override
    public Cartitem findByUserId(String cartitemId) {
        return null;
    }

    @Override
    public int deleteByUserId(String cartitemId) {
        return 0;
    }

    @Override
    public Cartitem findByGoodsId(String goodsid) {
        return cartitemMapper.findByGoodsId(goodsid);
    }

    @Override
    public int updateCartItemAddNumber(String goodsid, int number) {
        return cartitemMapper.updateCartItemAddNumber(goodsid,number);
    }

    @Override
    public int updateCartItemAddTotalPrice(String goodsid, double totalPrice) {
        return cartitemMapper.updateCartItemAddTotalPrice(goodsid,totalPrice);
    }

    @Override
    public List<Cartitem> findAllByUserId(String buyerid) {
        return cartitemMapper.findAllByUserId(buyerid);
    }

    @Override
    public int deleteByGoodsCartItemId(String goodsCartItemId) {
        return cartitemMapper.deleteByGoodsCartItemId(goodsCartItemId);
    }

}
