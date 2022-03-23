package com.nowcoder.community.community.service.impl;

import com.nowcoder.community.community.dao.DiscussPostMapper;
import com.nowcoder.community.community.entity.DiscussPost;
import com.nowcoder.community.community.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Override
    public List<DiscussPost> findDiscusspost(int userId, int offset, int limit) {
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(userId, offset, limit);
        return discussPosts;
    }

    @Override
    public int findDiscussPostRows(int userId) {
        int rows = discussPostMapper.selectDiscussPostRows(userId);
        return rows;
    }
}
