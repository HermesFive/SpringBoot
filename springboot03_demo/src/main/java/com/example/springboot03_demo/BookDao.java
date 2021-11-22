package com.example.springboot03_demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot03_demo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
