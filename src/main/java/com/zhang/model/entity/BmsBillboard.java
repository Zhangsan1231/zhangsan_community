package com.zhang.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
//Builder Accessors 可以使我们的类支持链式操作
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("bms_billboard")
@ApiModel(description = "公告版类")
public class BmsBillboard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)//指明表id为自增
    @ApiModelProperty(value = "公告版Id")
    private Integer id;

    @TableField("content")
    @ApiModelProperty(value = "公告版内容")
    private String content;

//    fill = FieldFill.INSERT 插入的时候自动填充当前时间
    @TableField(value = "create_time" ,fill = FieldFill.INSERT)
    @ApiModelProperty(value = "公告时间")
    private Date createTime;

    @Builder.Default    //默认构建
    @TableField("`show`")
    @ApiModelProperty(value = "是否公告")
    private boolean show = false;   //false（0）：过期， true（1）：正在展示

}
