package com.example.springboot03_demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot03_demo.Service.BookService;
import com.example.springboot03_demo.Service.IBookService;
import com.example.springboot03_demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03DemoApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookService bookService;



    @Test
    void TestSelectById() {
        System.out.println(bookDao.selectById(1001));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("体育");
        book.setName("篮球");
        book.setDescription("篮球入门教学");
        bookService.save(book);
    }

    @Test
    void testSelectAll(){
        bookService.getAll();
    }

    @Test
    void testGetPage(){
        IPage ipage = new Page(1,2);
        bookDao.selectPage(ipage,null);
    }

    @Test
    void testSelectBy(){
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        String description = "入门";
        qw.like(description!=null,Book::getDescription,description);
        bookDao.selectList(qw);
    }

    @Test
    void testDelete(){
        bookService.delete(1003);
    }
    @Test
    void testServiceGetPage(){
        bookService.getPage(1,2);
    }

}
