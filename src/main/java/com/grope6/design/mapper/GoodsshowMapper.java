package com.grope6.design.mapper;

import com.grope6.design.entity.Goodsshow;
import com.grope6.design.entity.GoodsshowExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsshowMapper {
    int countByExample(GoodsshowExample example);

    int deleteByExample(GoodsshowExample example);

    @Insert("insert into Goodsshow value (#{goodsid},#{picturepath})")
    int insert(Goodsshow record);

    int insertSelective(Goodsshow record);

    List<Goodsshow> selectByExample(GoodsshowExample example);

    int updateByExampleSelective(@Param("record") Goodsshow record, @Param("example") GoodsshowExample example);

    int updateByExample(@Param("record") Goodsshow record, @Param("example") GoodsshowExample example);

    @Insert("delete from goodsshow where goodsid = #{goodsId}")
    int deleteByGoodsId(String goodsId);

    @Update("update goodsshow set " +
            "picturepath = #{picturepath} " +
            "where goodsid = #{goodsid}")
    int update(Goodsshow goodsshow);

    @Select("select * from Goodsshow")
    List<Goodsshow> findAll();
}