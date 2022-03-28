package com.nowcoder.community.community.dao;

import com.nowcoder.community.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    int insertUser(User record);
    List<User> selectAll();
    User findUserById(@Param("userId") int userId);

    User findUserNameById(@Param("userId") String userId);

    User selectByName(String username);

    User selectByEmail(String email);

    int updateStatus(@Param("id")int id, @Param("status")int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

    int updatePasswordByUserId(int userId, String newPassword);
}