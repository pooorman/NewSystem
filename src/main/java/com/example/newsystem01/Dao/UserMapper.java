package com.example.newsystem01.Dao;

import com.example.newsystem01.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

    @Select("select * from user where user_name = #{username}")
    User getUserByName(String username);

    @Insert("insert into user (user_name, password) values (#{username}, #{password})")
    Integer insertUser(User user);

}
