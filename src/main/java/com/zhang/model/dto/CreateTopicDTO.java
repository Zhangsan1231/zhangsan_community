package com.zhang.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
//接收前端传来发帖的类
@Data
public class CreateTopicDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private List<String> tags;

}
