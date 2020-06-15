package com.janguo;

import com.janguo.janguolibrary.JanGuoLibraryApplication;
import com.janguo.janguolibrary.dao.TicketDao;
import com.janguo.janguolibrary.dao.UserDao;
import com.janguo.janguolibrary.model.Ticket;
import com.janguo.janguolibrary.model.User;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest(classes = JanGuoLibraryApplication.class)
public class TestSpringTicket {

    @Resource
    TicketDao ticketDao;



    @Test
    public void TestTicket(){
        Ticket ticket = new Ticket();
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(new Date());
        ticket.setUserId(1);
        ticket.setTicket("不错");
        ticket.setExpiredAt(calendar.toString());
        ticketDao.addTicket(ticket);
    }
    @Test
    public void TestTicketById(){

        Ticket ticket = ticketDao.selectByUserId(4);
        System.out.println(ticket);
    }
    @Test
    public void TestTicketByT(){

        Ticket ticket = ticketDao.selectByTicket("不错");
        System.out.println(ticket);
    }
    @Test
    public void TestDeleteTicketById(){

        ticketDao.deleteTicketById(1);
    }
    @Test
    public void TestDeleteTicketByT(){

        ticketDao.deleteTicket("不错");
    }

    @Test
    public void TestTicketByUId(){

        System.out.println(ticketDao.selectByUserUId(2));
    }
}
