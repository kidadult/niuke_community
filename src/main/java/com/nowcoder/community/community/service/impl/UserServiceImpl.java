package com.nowcoder.community.community.service.impl;

import com.nowcoder.community.community.dao.UserMapper;
import com.nowcoder.community.community.entity.User;
import com.nowcoder.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int userId) {
        User user = userMapper.findUserById(userId);
        return user;
    }

    @Override
    public User findUserNameById(String userId) {
        User userName = userMapper.findUserNameById(userId);
        return userName;
    }
}
