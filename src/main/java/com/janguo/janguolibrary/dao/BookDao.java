package com.janguo.janguolibrary.dao;

import com.janguo.janguolibrary.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper
public interface BookDao {

    @Insert("INSERT INTO book(name, author,price,status) VALUES (#{name}, #{author},#{price}, #{status})")
    boolean addBook(Book book);

    @Select("Select * From book")
    List<Book> getAll();

    @Select("Select * From book where id = #{id}")
    Book getBookById(int id);

    @Select("Select * From book where name = #{name}")
    Book getBookByName(String name);

    @Delete("delete from book where id = #{id}")
    boolean deleteBookById(int id);

    //    @Update("update book set name=#{name},author=#{author},price=#{price},status=#{status} where id=#{id}")
    @Update("update book set price=#{price} where id=#{id}")
    boolean updateById(Book book);
}
