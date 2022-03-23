package com.nowcoder.community.community.dao;

import com.nowcoder.community.community.entity.Comment;


import java.util.List;
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}