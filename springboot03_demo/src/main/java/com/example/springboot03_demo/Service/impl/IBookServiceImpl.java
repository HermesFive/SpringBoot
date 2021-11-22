package com.example.springboot03_demo.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot03_demo.BookDao;
import com.example.springboot03_demo.Service.IBookService;
import com.example.springboot03_demo.domain.Book;

public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
