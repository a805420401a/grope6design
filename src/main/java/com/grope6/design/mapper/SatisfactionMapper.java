package com.grope6.design.mapper;

import com.grope6.design.entity.Satisfaction;
import com.grope6.design.entity.SatisfactionExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SatisfactionMapper {
    int countByExample(SatisfactionExample example);

    int deleteByExample(SatisfactionExample example);

    int insert(Satisfaction record);

    int insertSelective(Satisfaction record);

    List<Satisfaction> selectByExample(SatisfactionExample example);

    int updateByExampleSelective(@Param("record") Satisfaction record, @Param("example") SatisfactionExample example);

    int updateByExample(@Param("record") Satisfaction record, @Param("example") SatisfactionExample example);

    @Insert("insert into satisfaction value (#{buyerid},#{merchantid},#{quality},#{attitude},#{logistics},#{synthesize})")
    int InsertSatisfaction(Satisfaction satisfaction);
}