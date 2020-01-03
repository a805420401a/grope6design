package com.grope6.design.service.impl;

import com.grope6.design.entity.Customer;
import com.grope6.design.mapper.CustomerMapper;
import com.grope6.design.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Customer findByUserId(String buyerId) {
        return customerMapper.selectByBuyerId(buyerId);
    }

    @Override
    public int deleteByUserId(String buyerId) {
        return 0;
    }
}
