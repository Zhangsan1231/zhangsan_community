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
@TableName("bms_comment")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "评论类")
public class BmsComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "内容")
    @NotBlank(message = "内容不可以为空")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "作者ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "帖子ID")
    @TableField("topic_id")
    private String topicId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;
}
