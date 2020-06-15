package com.janguo.janguolibrary.controllers;

import com.janguo.janguolibrary.model.Book;
import com.janguo.janguolibrary.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@ResponseBody
@SessionAttributes(value = "book")
@RequestMapping("/test")
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @RequestMapping("/addbook")
    public String addBook(@RequestParam(required = false,value = "name") String name){
        Book book = new Book();
        book.setAuthor("李先生");
        book.setPrice("100￥");
        book.setStatus(false);
        book.setName(name);
        boolean result = bookService.addBook(book);
        if (!result){
            return "失败";
        }
        return "成功";

    }

    @ResponseBody
    @RequestMapping("/getbooks")
    public  List<Book> getAllBook(){
        List<Book> books = bookService.getAll();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(books);
        return books;
    }


    @ResponseBody
    @RequestMapping(value = "/getbook",params = "name",method = RequestMethod.GET)
    public Book getBookByName(String name){
        Book book = bookService.getBook(name);
        System.out.println(book);
        return book;
    }

    @ModelAttribute("book")
    @RequestMapping("setsession")
    public Book getBookByName2(){
        Book book = new Book();
        book.setName("好书");
        book.setAuthor("li");
        System.out.println(book);
        return book;
    }

    @RequestMapping("/delete/{name}")
    public String deleteBookByName(@PathVariable("name") String name){
        boolean result = bookService.deleteBookByName(name);
        if (result){
           logger.info("删除名为：《"+name+"》的书成功");
           return "成功";
        }else {
            logger.info("删除名为：《"+name+"》的书！！！！失败");
            return "error";
        }
    }

    @RequestMapping("/session")
    public String getBook(@ModelAttribute("book") Book book, HttpSession session){
        System.out.println(book.getName());
        Object book1 = session.getAttribute("book");

        System.out.println(book1);
        return "/index";

    }

    @RequestMapping("updatebookprice")
    @ResponseBody
    public String updateBookPriceByName(@RequestParam(required = true,value = "name") String name,
                                        @RequestParam(required = true,value = "price") String price){
        boolean result = bookService.updateBookPriceByName(name, price);
        if (result){
            return "SUSSES";
        }
        return "修改失败";

    }
}
