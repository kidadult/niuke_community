package com.nowcoder.community.community.dao;

import com.nowcoder.community.community.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);
    List<User> selectAll();
    User findUserById(@Param("userId") int userId);

    User findUserNameById(@Param("userId") String userId);
}