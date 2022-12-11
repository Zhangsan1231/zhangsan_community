package com.zhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.dto.LoginDTO;
import com.zhang.model.dto.RegisterDTO;
import com.zhang.model.entity.UmsUser;
import com.zhang.model.vo.ProfileVO;


//mybatis-plus继承IService
public interface IUmsUserService extends IService<UmsUser> {
//    注册
    UmsUser executeRegister(RegisterDTO registerDTO);
//    根据用户名查找
    UmsUser getUserByUserName(String name);
//    用户登录
    String executeLogin(LoginDTO loginDTO);
    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);
}
