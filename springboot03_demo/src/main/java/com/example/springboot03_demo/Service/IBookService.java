package com.example.springboot03_demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot03_demo.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface IBookService extends IService<Book> {
}
