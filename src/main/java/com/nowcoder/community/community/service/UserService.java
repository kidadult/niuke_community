package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.LoginTicket;
import com.nowcoder.community.community.entity.User;

import java.util.Map;

public interface UserService {
     User findUserById(int UserId);
     User findUserNameById(String UserId);
     Map<String,Object> register(User user);
     int activation(int userId, String code);
     Map<String,Object> login(String username,String password,int expiredSeconds);

    void logout(String ticket);

     LoginTicket findLoginTicket(String ticket);
     int updateHeader(int userId,String headerUrl);

    int updatePasswordByUserId(int userId, String newPassword);

    User findUserByName(String name);
}
