package com.janguo.janguolibrary.model;


import lombok.Data;

import java.util.Date;

@Data
public class Ticket {

    private int id;
    /**
     * 相绑定的userID
     */
    private int userId;
    /**
     * T票实体
     */
    private String ticket;

    /**
     * 过期时间
     */
    private Date expiredAt;
}
