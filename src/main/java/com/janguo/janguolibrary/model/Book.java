package com.janguo.janguolibrary.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    /**
     * 图书名字
     */
    private String name;
    /**
     * 图书作者
     */
    private String author;
    /**
     * 图书价格
     */
    private String price;
    /**
     * 状态
     */
    private boolean status;
}
