package com.janguo.janguolibrary.dao;

import com.janguo.janguolibrary.model.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TicketDao {

    @Insert({"insert into ticket (user_id,ticket,expired_at) values (#{userId},#{ticket},#{expiredAt})"})
    int addTicket(Ticket ticket);

    @Select("Select * from ticket where id = #{id}")
    Ticket selectByUserId(int id);

    @Select("select * from ticket where ticket = #{t}")
    Ticket selectByTicket(String t);

    @Delete("delete from ticket where id = #{tid}")
    void deleteTicketById(int tid);

    @Delete("delete from ticket where ticket = #{t}")
    void deleteTicket(String t);
}
