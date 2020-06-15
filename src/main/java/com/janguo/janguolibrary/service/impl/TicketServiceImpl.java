package com.janguo.janguolibrary.service.impl;

import com.janguo.janguolibrary.dao.TicketDao;
import com.janguo.janguolibrary.model.Ticket;
import com.janguo.janguolibrary.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDao ticketDao;
    @Override
    public void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    @Override
    public Ticket getTicket(Ticket t) {
        int id = t.getId();
        return getTicketById(id);
    }

    @Override
    public Ticket getTicketByUserId(int uid) {
        return ticketDao.selectByUserUId(uid);
    }

    @Override
    public Ticket getTicketById(int id) {
        return ticketDao.selectByTId(id);
    }

    @Override
    public Ticket getTicketByT(String t) {
        return ticketDao.selectByTicket(t);
    }

    @Override
    public boolean deleteTickedByTId(int tid) {
        return ticketDao.deleteTicketById(tid);
    }

    @Override
    public boolean deleteTickedByT(String t) {
        return ticketDao.deleteTicket(t);
    }
}
