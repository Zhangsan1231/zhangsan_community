package com.zhang.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("bms_follow")
@ApiModel(description = "关注类")
public class BmsFollow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty("被关注人id")
    @TableField("parent_id")
    private String parentId;


    @ApiModelProperty("关注人id")
    @TableField("follower_id")
    private String followerId;

    public BmsFollow() {
    }

}
