package com.nowcoder.community.community.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Message {
    private int id;

    private int fromId;

    private int toId;

    private String conversationId;  //会话Id

    private int status;

    private Date createTime;

    private String content;

}