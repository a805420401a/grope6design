package com.grope6.design.mapper;

import com.grope6.design.entity.Customer;
import com.grope6.design.entity.CustomerExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    @Insert("insert into customer value (#{buyerid},#{name},#{phone},#{address})")
    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    @Select("select * from customer where buyerid = #{buyerid}")
    Customer selectByBuyerId(String buyerid);

    @Update("update customer set " +
            "name = #{name} , phone = #{phone} , address = #{address} " +
            "where buyerid = #{buyerid}")
    int updateCustomer(Customer customer);
}