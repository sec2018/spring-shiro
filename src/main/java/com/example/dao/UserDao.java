package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.pojo.User;


/**
 * Created by WangZJ on 2018/8/13.
 */
@Mapper
public interface UserDao {
    @Select("select password from user where username = #{username}")
    String getPasswordByUserName(@Param("username") String username);
    
    @Select("SELECT u.* FROM user u inner join user_role ur on ur.uid=u.uid WHERE username=#{name};")
    User findUserByName(@Param("name")String name);
}
