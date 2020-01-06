package com.grope6.design.mapper;

import com.grope6.design.entity.Indentitem;
import com.grope6.design.entity.IndentitemExample;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface IndentitemMapper {
    int countByExample(IndentitemExample example);

    int deleteByExample(IndentitemExample example);

    int deleteByPrimaryKey(String indentitemid);

    @Insert("insert into indentitem value (#{indentitemid},#{buyerid},#{goodsid},#{price},#{number},#{indentdatetime},#{paystate},#{finishstate})")
    int insert(Indentitem record);

    int insertSelective(Indentitem record);

    List<Indentitem> selectByExample(IndentitemExample example);

    Indentitem selectByPrimaryKey(String indentitemid);

    int updateByExampleSelective(@Param("record") Indentitem record, @Param("example") IndentitemExample example);

    int updateByExample(@Param("record") Indentitem record, @Param("example") IndentitemExample example);

    int updateByPrimaryKeySelective(Indentitem record);

    int updateByPrimaryKey(Indentitem record);

    @Select("select * from indentitem where buyerid = #{buyerId}")
    List<Indentitem> findAllByBuyerId(String buyerId);

    @Update("update indentitem set " +
            "paystate = 1 " +
            "where indentitemid = #{indentItemId}")
    int updatePayStateByIndentItemId(String indentItemId);

    @Update("update indentitem set " +
            "finishstate = 1 " +
            "where indentitemid = #{indentItemId}")
    int updateFinishStateByIndentItemId(String indentItemId);

    @Select("select * from indentitem where indentitemid = #{indentItemId}")
    Indentitem findByIndentItemId(String indentItemId);
}