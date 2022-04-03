package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.Comment;
import org.thymeleaf.model.IComment;

import java.util.List;

public interface CommentService {
     List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit);
     int findCommentCount(int entityType, int entityId);

    int addComment(Comment comment);
}