package com.grope6.design.mapper;

import com.grope6.design.entity.Customer;
import com.grope6.design.entity.CustomerExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}