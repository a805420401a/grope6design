package com.grope6.design.mapper;

import com.grope6.design.dto.GoodsQryItem;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.GoodsExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    @Delete("DELETE FROM goods WHERE goodsid = #{goodsid}")
    int deleteByPrimaryKey(String goodsid);

    @Insert("insert into goods value (#{goodsid},#{merchantid},#{name},#{number},#{price}," +
            "#{discount},#{description},#{manufacturedate},#{manufacturer},#{durableyears})")
    int insert(Goods goods);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    @Select("select * from goods")
    List<Goods> findAll();

    Goods selectByPrimaryKey(String goodsid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    @Update("update goods set " +
            "name = #{name}," +
            "number = #{number}," +
            "price = #{price}," +
            "discount = #{discount}," +
            "description = #{description}," +
            "manufacturedate = #{manufacturedate}," +
            "manufacturer = #{manufacturer}," +
            "durableyears = #{durableyears} " +
            "where goodsid = #{goodsid}")
    int updateByPrimaryKey(Goods goods);

    @Select("select * from goods where merchantid = #{merchantid}")
    List<Goods> GoodsinfoSelect(String merchantid);

    @Select("select * from goods where goodsid = #{Goodsid}")
    Goods findByGoodsId(String goodsid);
}