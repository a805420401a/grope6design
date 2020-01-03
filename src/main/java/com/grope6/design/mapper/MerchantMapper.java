package com.grope6.design.mapper;

import com.grope6.design.entity.Merchant;
import com.grope6.design.entity.MerchantExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MerchantMapper {
    int countByExample(MerchantExample example);

    int deleteByExample(MerchantExample example);

    @Insert("insert into merchant value " +
            "(#{merchantid},#{name}),#{address}," +
            "#{reputation},#{legalperson},#{totalassets}")
    int insert(Merchant record);

    int insertSelective(Merchant record);

    List<Merchant> selectByExample(MerchantExample example);

    int updateByExampleSelective(@Param("record") Merchant record, @Param("example") MerchantExample example);

    int updateByExample(@Param("record") Merchant record, @Param("example") MerchantExample example);

    @Select("select * from merchant where merchantid = #{merchantid}")
    Merchant selectByUserId(String merchantid);
}