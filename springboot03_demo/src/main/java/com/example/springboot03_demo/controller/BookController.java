package com.example.springboot03_demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot03_demo.Service.BookService;
import com.example.springboot03_demo.domain.Book;
import com.example.springboot03_demo.utils.getMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.springboot03_demo.utils.getMap;

@CrossOrigin(value = "http://localhost:56576", maxAge = 1800, allowedHeaders = "*")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @ResponseBody
    public Map<String,Object> getAllBooks(){
        List<Book> books = bookService.getAll();

        if (books.size()>0){
            return getMap.success(books);
        }else {
            return getMap.error();
        }

    }

    @GetMapping("/{id}")
    public Map<String,Object> getBookById(@PathVariable Integer id){
        if (bookService.getById(id)!=null){
            return getMap.success(bookService.getById(id));
        }else {
            return getMap.error();
        }
    }


    @CrossOrigin(value = "http://localhost:56576", maxAge = 1800, allowedHeaders = "*")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Map<String,Object> deleteBookById(@PathVariable Integer id){
        if (bookService.delete(id)){
            return getMap.success(null);
        }else{
            return getMap.error();
        }
    }

    @PostMapping("/add")
    public Map<String,Object> addBook(@RequestBody Book book){
        bookService.save(book);
        return getMap.success(null);
    }

    @PostMapping("/update")
    public Map<String,Object> updateBook(@RequestBody Book book){
       if (bookService.update(book)){
           return getMap.success(bookService.getAll());
       }else {
           return getMap.error();
       }
    }

    @GetMapping("/{current}/{size}")
    @ResponseBody
    public Map<String,Object> getPage(@PathVariable Integer current, @PathVariable Integer size,Book book){
        System.out.println("------"+book + "dewdbsjbdc");
        IPage page = bookService.getPage(current,size,book);
        if (current > page.getPages()){
            page = bookService.getPage((int)page.getPages(),size,book);
        }
        return getMap.success(page);
    }
}
