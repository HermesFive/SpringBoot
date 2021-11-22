package com.example.springboot02_module.dao;

import com.example.springboot02_module.controller.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    @Select("select * from td_book where id = #{id}")
    public Book getById(Integer id);
}
