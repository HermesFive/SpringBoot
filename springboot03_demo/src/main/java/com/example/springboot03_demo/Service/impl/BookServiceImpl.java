package com.example.springboot03_demo.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot03_demo.BookDao;
import com.example.springboot03_demo.Service.BookService;
import com.example.springboot03_demo.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookdao;

    @Override
    public Boolean save(Book book) {
        return bookdao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookdao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookdao.deleteById(id)> 0 ;
    }

    @Override
    public Book getById(Integer id) {
        return bookdao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage,pageSize);
        return bookdao.selectPage(page,null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> page = new Page(currentPage,pageSize);
        bookdao.selectPage(page,lqw);
        return page;
    }
}
