package com.janguo.janguolibrary.service;

import com.janguo.janguolibrary.model.Ticket;

public interface TicketService {
    void addTicket(Ticket ticket);

    Ticket getTicket(Ticket t);

    Ticket getTicketByUserId(int uid);

    Ticket getTicketById(int id);

    Ticket getTicketByT(String t);

    boolean deleteTickedByTId(int tid);

    boolean deleteTickedByT(String t);
}
