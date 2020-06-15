package com.janguo.janguolibrary.controllers;

import com.janguo.janguolibrary.biz.LoginBiz;
import com.janguo.janguolibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    LoginBiz loginBiz;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String doLogin(@RequestParam(required = true, value = "email") String email,
                          @RequestParam(required = true, value = "password") String password) {
        String s = loginBiz.login(email, password);

        if (s != null) {
            return "Login Success!";
        } else {
            return "Login Filed!";
        }
    }


    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String doRegister(
            @RequestParam(required = true, value = "name") String name,
            @RequestParam(required = true, value = "email") String email,
            @RequestParam(required = true, value = "password") String password) {
        User user = new User(name, email, password);
        String register = loginBiz.register(user);

        if (register != null) {
            return "Register Success!";
        } else {
            return "Register Filed@";
        }
    }
}
