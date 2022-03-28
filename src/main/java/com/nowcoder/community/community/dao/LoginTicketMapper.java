package com.nowcoder.community.community.dao;

import com.nowcoder.community.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface LoginTicketMapper {

    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket record);

    @Select({
            "select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    //展示一下动态sql,在这里并没有实际意义
    @Update({
            "<script>",
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
            "<if test=\"ticket!=null\"> ",
            "and 1=1 ",
            "</if>",
            "</script>"
    })
    int updateStatus(String ticket,int status);

    List<LoginTicket> selectAll();
    LoginTicket selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(LoginTicket record);
}