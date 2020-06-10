package com.janguo;

import com.janguo.janguolibrary.JanGuoLibraryApplication;
import com.janguo.janguolibrary.dao.UserDao;
import com.janguo.janguolibrary.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = JanGuoLibraryApplication.class)
public class TestSpringUser {

    @Resource
    UserDao userDao;

    @Test
    public void testSetUser(){
        User user = new User("li","163@163.com","123456");

        userDao.addUser(user);

    }

    @Test
    public void testGetUserById(){

        System.out.println(userDao.getUserById(1));

    }
    @Test
    public void testGetUserByName(){

        System.out.println(userDao.getUserByName("li"));

    }

    @Test
    public void testGetUserByEmail(){

        System.out.println(userDao.getUserByEmail("163@163.com"));

    }

    @Test
    public void testUpDateUser(){
        User user = new User(2,"li","163@163.com","654321");

        userDao.updatePassword(user);

    }
}
