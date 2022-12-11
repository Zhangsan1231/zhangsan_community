package com.zhang.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//对应Regestier.vue传来的参数
@Data
public class RegisterDTO {

//    通过validation 的    @NotEmpty注解 来设置为不为空，    NotEmpty一般对列表使用
//    通过hibernate的  @Length注解 来检验长度
    @NotEmpty(message = "请输入账号")
    @Length(min = 2,max = 15,message = "长度在2-15")
    private String name;
    @NotEmpty(message = "请输入密码")
    @Length(min = 6,max = 20,message = "长度在6-20")
    private String pass;
    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6,max = 20,message = "长度在6-20")
    private String checkPass;
    @NotEmpty(message = "请输入电子邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

}
