package com.example.springboot03_demo.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot03_demo.domain.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
