package com.janguo.janguolibrary.service;

import com.janguo.janguolibrary.model.Book;

import java.util.List;

public interface BookService {

    /**
     * 添加图书
     * @param book 传入要添加的图书对象
     * @return 返回成功或者失败
     */
    boolean addBook(Book book);

    /**
     * 获得所有图书
     * @return 返回Book的List集合
     */
    List<Book> getAll();

    /**
     * 通过ID获得指定图书
     * @param id 要查询的图书ID
     * @return 查询结果对象
     */
    Book getBook(int id);

    Book getBook(String name);

    /**
     * 删除指定名称的Book数据
     * @param name 要删除的图书的名字
     * @return 返回成功与否
     */
    boolean deleteBookByName(String name);

    /**
     * 更新传入名字的图书的价格
     * @param name 要修改的图书名字
     * @param price 修改后的价格
     * @return 返回成功与否
     */
    boolean updateBookPriceByName(String name,String price);
}
