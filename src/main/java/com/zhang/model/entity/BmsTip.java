package com.zhang.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("bms_tip")
@Builder
@Accessors(chain = true)
@ApiModel(description = "每日一句类")
public class BmsTip implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
    private Integer id;
    @TableField("content")
    @ApiModelProperty("名言")
    private String content;
    @TableField("author")
    @ApiModelProperty("作者")
    private String author;
    @TableField("`type`")
    @ApiModelProperty("1：使用；0：过期")
    private boolean type;


}
