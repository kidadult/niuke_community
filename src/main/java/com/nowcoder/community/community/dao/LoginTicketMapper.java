package com.nowcoder.community.community.dao;

import com.nowcoder.community.community.entity.LoginTicket;


import java.util.List;
public interface LoginTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginTicket record);

    LoginTicket selectByPrimaryKey(Integer id);

    List<LoginTicket> selectAll();

    int updateByPrimaryKey(LoginTicket record);
}