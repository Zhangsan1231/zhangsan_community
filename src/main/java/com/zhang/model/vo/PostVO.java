package com.zhang.model.vo;

import com.zhang.model.entity.BmsTag;
import com.zhang.model.entity.BmsTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "传给前端的帖子详情类")
public class PostVO implements Serializable {
    private static final long serialVersionUID = -261082150965211545L;

    @ApiModelProperty("文章ID")
    private String id;

    @ApiModelProperty("文章创建人用户ID")
    private String userId;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("文章对应用户昵称")
    private String alias;

    @ApiModelProperty("文章 账号")
    private String username;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章评论统计")
    private Integer comments;

    @ApiModelProperty("文章置顶")
    private Boolean top;

    @ApiModelProperty("文章加精")
    private Boolean essence;

    @ApiModelProperty("文章收藏次數")
    private Integer collects;

    @ApiModelProperty("话题关联标签")
    private List<BmsTag> tags;

    @ApiModelProperty("文章浏览量")
    private Integer view;

    @ApiModelProperty("文章创建时间")
    private Date createTime;

    @ApiModelProperty("文章修改时间")
    private Date modifyTime;
}
