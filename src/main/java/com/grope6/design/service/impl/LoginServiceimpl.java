package com.grope6.design.service.impl;

import com.grope6.design.entity.Login;
import com.grope6.design.entity.LoginExample;
import com.grope6.design.mapper.LoginMapper;
import com.grope6.design.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<Login> findAll() {
        return null;
    }

    @Override
    public int updateLogin(Login login) {
        return 0;
    }

    @Override
    public int insertLogin(Login login) {
        return 0;
    }

    @Override
    public Login findByUserId(String userId) {
        return loginMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int deleteByUserId(String userId) {
        return 0;
    }
}
