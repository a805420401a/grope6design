package com.grope6.design.service.impl;

import com.grope6.design.entity.Satisfaction;
import com.grope6.design.mapper.SatisfactionMapper;
import com.grope6.design.service.SatisfactionServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SatisfactionServletimpl implements SatisfactionServlet {

    @Autowired
    SatisfactionMapper satisfactionMapper;

    @Override
    public int InsertSatisfaction(Satisfaction satisfaction) {
        return satisfactionMapper.InsertSatisfaction(satisfaction);
    }
}
