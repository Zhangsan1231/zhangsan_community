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
@TableName("bms_promotion")
@Builder
@Accessors(chain = true)
@ApiModel(description = "广告类")
public class BmsPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("title")
    @ApiModelProperty("广告标题")
    private String title;
    @ApiModelProperty("广告链接")
    @TableField("link")
    private String link;
    @TableField("description")
    @ApiModelProperty("广告描述")
    private String description;


}
