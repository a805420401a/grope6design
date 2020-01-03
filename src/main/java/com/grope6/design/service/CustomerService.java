package com.grope6.design.service;

import com.grope6.design.entity.Customer;
import com.grope6.design.entity.Login;

import java.util.List;

public interface CustomerService {
    //查询所有
    List<Customer> findAll();

    //更新
    int updateCustomer(Customer customer);

    //插入
    int insertCustomer(Customer customer);

    //根据id查询
    Customer findByUserId(String buyerId);

    //根据id删除
    int deleteByUserId(String buyerId);
}
