package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.DiscussPost;

import java.util.List;

public interface DiscussService {
    List<DiscussPost> findDiscusspost(int userId,int offset,int limit);
    int findDiscussPostRows(int userId);
    int addDiscussPost(DiscussPost discussPost);
    DiscussPost findDiscussPostById(int id);

    int updateCommentCount(int id,int commentCount);

}
