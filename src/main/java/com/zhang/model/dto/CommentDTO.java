package com.zhang.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
//接收前端传来的评论类
public class CommentDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    //帖子id
    private String topic_id;

    /**
     * 内容
     */
    private String content;



}
