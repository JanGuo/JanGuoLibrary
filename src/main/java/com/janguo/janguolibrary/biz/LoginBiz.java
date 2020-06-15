package com.janguo.janguolibrary.biz;

import com.janguo.janguolibrary.model.Ticket;
import com.janguo.janguolibrary.model.User;
import com.janguo.janguolibrary.model.exceptions.LoginRegisterException;
import com.janguo.janguolibrary.service.TicketService;
import com.janguo.janguolibrary.service.UserService;
import com.janguo.janguolibrary.utils.MD5;
import com.janguo.janguolibrary.utils.TicketUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginBiz {

    @Autowired
    UserService userService;
    @Autowired
    TicketService ticketService;

    public String login(String email, String password) {
        User user = userService.getUserByEmail(email);
        if (user == null) throw new LoginRegisterException("邮箱不存在");
        if (!StringUtils.equals(MD5.next(password), user.getPassword()))
            throw new LoginRegisterException("密码不正确");

        Ticket ticket = ticketService.getTicketById(user.getId());

        if (ticket == null) {
            ticket = TicketUtils.next(user.getId());
            ticketService.addTicket(ticket);
            return ticket.getTicket();
        }

        if (ticket.getExpiredAt().before(new Date())) {
            ticketService.deleteTickedByTId(ticket.getId());
        }

//        ticket = TicketUtils.next(user.getId());
//        ticketService.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String s) {
        ticketService.deleteTickedByT(s);
    }

    public String register(User user) {
        if (user.getEmail() == null) {
            throw new LoginRegisterException("邮箱不能为空！");
        } else if (user.getPassword() == null) {
            throw new LoginRegisterException("密码不能为空");
        }
        if (userService.getUserByEmail(user.getEmail()) != null) {
            throw new LoginRegisterException("该有邮箱已经被注册！");
        }

        String password = user.getPassword();

        String passwordMD5 = MD5.next(password);

        user.setPassword(passwordMD5);
        boolean result = userService.addUser(user);

        if (result){
            Ticket ticket = TicketUtils.next(userService.getUserByEmail(user.getEmail()).getId());
            ticketService.addTicket(ticket);
            return ticket.getTicket();
        }
        return null;
    }

}
