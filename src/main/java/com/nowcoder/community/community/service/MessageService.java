package com.nowcoder.community.community.service;

import com.nowcoder.community.community.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> findConversations(int userId, int offset, int limit);
    int findConversationsCount(int userId);
    List<Message> findLetters(String conversationId,int offset,int limit);
    int findLettersCount(String conversationId);
    int findLettersUnreadCount(int userId,String conversationId);

    int addMessage(Message message);
    int updateMessageStatusToRead(List<Integer> ids);

}
