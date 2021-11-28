package com.example.springboot03_demo.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03_demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from td_user where username = #{username}")
    public List<User> selectUserByUsername(@Param("username") String username);
}
