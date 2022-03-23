package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.DiscussPost;

import java.util.List;

public interface DiscussService {
    List<DiscussPost> findDiscusspost(int userId,int offset,int limit);
    public int findDiscussPostRows(int userId);
}
