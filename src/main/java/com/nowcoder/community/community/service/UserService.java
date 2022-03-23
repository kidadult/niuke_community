package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.User;

public interface UserService {
    public User findUserById(int UserId);
    public User findUserNameById(String UserId);
}
