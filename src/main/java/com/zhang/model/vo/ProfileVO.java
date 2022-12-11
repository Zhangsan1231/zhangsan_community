package com.zhang.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("传给前端的用户类")
public class ProfileVO {

    @ApiModelProperty("用户ID")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("别称")
    private String alias;


    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("关注数")
    private Integer followCount;

    @ApiModelProperty("关注者数")
    private Integer followerCount;

    @ApiModelProperty("文章数")
    private Integer topicCount;

    @ApiModelProperty("专栏数")
    private Integer columns;

    @ApiModelProperty("评论数")
    private Integer commentCount;

}
