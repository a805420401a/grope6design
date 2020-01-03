package com.grope6.design.mapper;

import com.grope6.design.entity.Login;
import com.grope6.design.entity.LoginExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    int countByExample(LoginExample example);

    int deleteByExample(LoginExample example);

    int deleteByPrimaryKey(String userid);

    @Insert("insert into login value (#{userid},#{userpassword},#{usertype})")
    int insert(Login login);

    int insertSelective(Login login);

    List<Login> selectByExample(LoginExample example);

    @Select("select * from login where userid = #{userid}")
    Login selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") Login login, @Param("example") LoginExample example);

    int updateByExample(@Param("record") Login login, @Param("example") LoginExample example);

    int updateByPrimaryKeySelective(Login login);

    int updateByPrimaryKey(Login login);
}