package com.zhang.model.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

//传给前端的评论详情
@ApiModel(description = "传给前端的评论详情")
@Data
public class CommentVO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("评论内容")
    private String content;
    @ApiModelProperty("对应评论的帖子id")
    private String topicId;
    @ApiModelProperty("评论者ID")
    private String userId;
    @ApiModelProperty("评论者用户名")
    private String username;
    @ApiModelProperty("评论时间")
    private Date createTime;

}
