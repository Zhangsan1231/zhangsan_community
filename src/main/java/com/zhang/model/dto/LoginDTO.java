package com.zhang.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
//对应Login.vue传来的参数
@Data
public class LoginDTO {

//    Notblant 一般对String类型来使用
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2,max = 15,message = "登录用户名长度在2-15")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(min = 6,max = 20,message = "密码长度在6-20")
    private String password;

    private Boolean remeberMe;
}
