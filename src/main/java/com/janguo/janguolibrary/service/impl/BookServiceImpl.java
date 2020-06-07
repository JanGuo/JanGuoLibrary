package com.janguo.janguolibrary.service.impl;

import com.janguo.janguolibrary.dao.BookDao;
import com.janguo.janguolibrary.model.Book;
import com.janguo.janguolibrary.model.exceptions.BookException;
import com.janguo.janguolibrary.service.BookService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public boolean addBook(Book book){
        boolean result = bookDao.addBook(book);
        if (!result){
            throw new BookException("添加书籍失败");
        }
        return result;
    };
    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Book getBook(String name) {
        return bookDao.getBookByName(name);
    }

    @Override
    public boolean deleteBookByName(String name) {
        Book bookByName = bookDao.getBookByName(name);
        if (bookByName == null){
            return false;
        }
        int id = bookByName.getId();
        boolean result = bookDao.deleteBookById(id);
        return result;
    }

    @Override
    public boolean updateBookPriceByName(String name,String price) {
        Book book = bookDao.getBookByName(name);
        book.setPrice(price);
        boolean result = bookDao.updateById(book);
        return result;
    }
}
