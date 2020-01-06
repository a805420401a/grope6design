package com.grope6.design.mapper;

import com.grope6.design.entity.Cartitem;
import com.grope6.design.entity.CartitemExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartitemMapper {
    int countByExample(CartitemExample example);

    int deleteByExample(CartitemExample example);

    int deleteByPrimaryKey(String cartitemid);

    @Insert("insert into cartitem value (#{cartitemid},#{buyerid},#{goodsid},#{goodsnumber},#{totalprice}) ")
    int insert(Cartitem record);

    int insertSelective(Cartitem record);

    List<Cartitem> selectByExample(CartitemExample example);

    Cartitem selectByPrimaryKey(String cartitemid);

    int updateByExampleSelective(@Param("record") Cartitem record, @Param("example") CartitemExample example);

    int updateByExample(@Param("record") Cartitem record, @Param("example") CartitemExample example);

    int updateByPrimaryKeySelective(Cartitem record);

    int updateByPrimaryKey(Cartitem record);

    @Select("select * from cartitem where goodsid = #{goodsid}")
    Cartitem findByGoodsId(String goodsid);

    @Update("update cartitem " +
            "set goodsnumber = goodsnumber + #{number} " +
            "where goodsid = #{goodsid}")
    int updateCartItemAddNumber(String goodsid, int number);

    @Update("update cartitem " +
            "set totalprice = totalprice + #{totalPrice} " +
            "where goodsid = #{goodsid}")
    int updateCartItemAddTotalPrice(String goodsid, double totalPrice);

    @Select("select * from cartitem where buyerid = #{buyerid}")
    List<Cartitem> findAllByUserId(String buyerid);

    @Delete("delete from cartitem where cartitemid = #{goodsCartItemId}")
    int deleteByGoodsCartItemId(String goodsCartItemId);
}