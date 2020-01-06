package com.grope6.design.service;

import com.grope6.design.entity.Indentitem;

import java.util.List;

public interface IndentItemService {
    //查询所有
    List<Indentitem> findAll();

    //更新
    int updateIndentitem(Indentitem indentitem);

    //插入
    int insertIndentitem(Indentitem indentitem);

    List<Indentitem>findAllByBuyerId(String buyerId);

    int updatePayStateByIndentItemId(String indentItemId);

    int updateFinishStateByIndentItemId(String indentItemId);

    Indentitem findByIndentItemId(String indentItemId);

}
