package com.janguo.janguolibrary.dao;

import com.janguo.janguolibrary.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Insert({"insert into user (name,email,password) values (#{name},#{email},#{password})"})
    int addUser(User user);

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    @Select("select * from user where email = #{email}")
    User getUserByEmail(String email);

    @Update("update user set password = #{password} where id = #{id}" )
    void updatePassword(User user);
}

