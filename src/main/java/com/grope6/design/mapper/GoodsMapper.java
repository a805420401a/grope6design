package com.grope6.design.mapper;

import com.grope6.design.dto.GoodsQryItem;
import com.grope6.design.entity.Goods;
import com.grope6.design.entity.GoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    int countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(String goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    @Select("select * from goods")
    List<Goods> findAll();

    Goods selectByPrimaryKey(String goodsid);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    @Select("select * from goods where merchantid = #{merchantid}")
    List<Goods> GoodsinfoSelect(String merchantid);
}