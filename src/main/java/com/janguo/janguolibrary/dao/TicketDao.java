package com.janguo.janguolibrary.dao;

import com.janguo.janguolibrary.model.Ticket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TicketDao {


    @Insert({"insert into ticket (user_id,ticket,expired_at) values (#{userId},#{ticket},#{expiredAt})"})
    int addTicket(Ticket ticket);

    @Select("Select * from ticket where id = #{id}")
    @Results(id = "TicketMap",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "userId", column = "user_id"),
                    @Result(property = "ticket", column = "ticket"),
                    @Result(property = "expiredAt", column = "expired_at")
            })
    Ticket selectByUserId(int id);

    @Select("Select * from ticket where user_id = #{uid}")
    @ResultMap(value = "TicketMap")
    Ticket selectByUserUId(int uid);

    @Select("select * from ticket where ticket = #{t}")
    Ticket selectByTicket(String t);

    @Delete("delete from ticket where id = #{tid}")
    void deleteTicketById(int tid);

    @Delete("delete from ticket where ticket = #{t}")
    void deleteTicket(String t);
}
