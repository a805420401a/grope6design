package com.grope6.design.service.impl;

import com.grope6.design.entity.Indentitem;
import com.grope6.design.mapper.IndentitemMapper;
import com.grope6.design.service.IndentItemService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentItemServiceimpl implements IndentItemService {

    @Autowired
    IndentitemMapper indentitemMapper;

    @Override
    public List<Indentitem> findAll() {
        return null;
    }

    @Override
    public int updateIndentitem(Indentitem indentitem) {
        return 0;
    }

    @Override
    public int insertIndentitem(Indentitem indentitem) {
        return indentitemMapper.insert(indentitem);
    }

    @Override
    public List<Indentitem> findAllByBuyerId(String buyerId) {
        return indentitemMapper.findAllByBuyerId(buyerId);
    }

    @Override
    public int updatePayStateByIndentItemId(String indentItemId) {
        return indentitemMapper.updatePayStateByIndentItemId(indentItemId);
    }

    @Override
    public int updateFinishStateByIndentItemId(String indentItemId) {
        return indentitemMapper.updateFinishStateByIndentItemId(indentItemId);
    }

    @Override
    public Indentitem findByIndentItemId(String indentItemId) {
        return indentitemMapper.findByIndentItemId(indentItemId);
    }
}
