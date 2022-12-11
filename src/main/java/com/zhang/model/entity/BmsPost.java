package com.zhang.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@TableName("bms_post")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "帖子类")
public class BmsPost implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("帖子id")
//    利用mybatis-plus的主键策略的 雪花算法给帖子id自动生成主键ID
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("帖子标题")
    @NotBlank(message = "标题不可以为空")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty("帖子内容")
    @NotBlank(message = "内容不可以为空")
    @TableField("`content`")
    private String content;


    @ApiModelProperty("作者ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("评论数")
    @TableField("comments")
    @Builder.Default
    private Integer comments = 0;


    @ApiModelProperty("收藏数")
    @TableField("collects")
    @Builder.Default
    private Integer collects = 0;

    @ApiModelProperty("浏览数")
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

    @ApiModelProperty("专栏ID，默认不分栏")
    @TableField("section_id")
    @Builder.Default
    private Integer sectionId = 0;


    @ApiModelProperty("置顶")
    @TableField("top")
    @Builder.Default
    private Boolean top = false;

    @ApiModelProperty("加精")
    @TableField("essence")
    @Builder.Default
    private Boolean essence = false;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;
}
