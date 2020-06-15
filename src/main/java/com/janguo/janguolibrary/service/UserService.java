package com.janguo.janguolibrary.service;

import com.janguo.janguolibrary.model.User;

public interface UserService {

    boolean addUser(User user);

    User getUserByEmail(String email);

    User getUserById(int id);

    User getUserByName(String name);
}
