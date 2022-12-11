package com.zhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.common.exception.ApiAsserts;
import com.zhang.jwt.JwtUtil;
import com.zhang.mapper.BmsFollowMapper;
import com.zhang.mapper.BmsTopicMapper;
import com.zhang.mapper.UmsUserMapper;
import com.zhang.model.dto.LoginDTO;
import com.zhang.model.dto.RegisterDTO;
import com.zhang.model.entity.BmsFollow;
import com.zhang.model.entity.BmsPost;
import com.zhang.model.entity.UmsUser;
import com.zhang.model.vo.ProfileVO;
import com.zhang.service.IBmsPostService;
import com.zhang.service.IUmsUserService;
import com.zhang.utils.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;

//ServiceImpl<BmsBillboardMapper, BmsBillboard> 这个方法需要两个类，一个是继承了mapper类，一个是实体类
@Service
public class IUmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser>
        implements IUmsUserService {
    @Resource
    private BmsTopicMapper bmsTopicMapper;
    @Resource
    private BmsFollowMapper bmsFollowMapper;

    @Override
    public UmsUser executeRegister(RegisterDTO registerDTO) {
//        查询是否有相同的用户名 或者 邮箱
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername, registerDTO.getName())
                .or()
                .eq(UmsUser::getEmail, registerDTO.getEmail());
        UmsUser umsUser = baseMapper.selectOne(wrapper);
        //        如果找到了说明有账号或者邮箱已经存在
        if (!ObjectUtils.isEmpty(umsUser))
            ApiAsserts.fail("账号或者邮箱已经存在");

//        构建一个UmsUser
        UmsUser addUser = UmsUser.builder()
                .username(registerDTO.getName())
                .alias(registerDTO.getName())
                .password(MD5Utils.getPwd(registerDTO.getPass()))
                .email(registerDTO.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);
        return addUser;
    }

    @Override
    public UmsUser getUserByUserName(String name) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UmsUser>().eq(UmsUser::getUsername, name));
    }

    @Override
    public String executeLogin(LoginDTO loginDTO) {
        String token = null;
        try {
            UmsUser user = getUserByUserName(loginDTO.getUsername());
            System.out.println(loginDTO.getPassword());
            String encodePwd = MD5Utils.getPwd(loginDTO.getPassword());

            if(!encodePwd.equals(user.getPassword())){
                throw new Exception("密码错误");
            }
//            通过用户名来生成token
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        }catch (Exception e){
            log.warn("用户名不存在或密码验证失败=====>"+loginDTO.getUsername());
        }

        return token;
    }

    @Override
    public ProfileVO getUserProfile(String id) {
        System.out.println("getUserProfile====>"+id);
        ProfileVO profileVO = new ProfileVO();
        UmsUser umsUser = baseMapper.selectById(id);
        Integer integer = bmsTopicMapper.selectCountById(id);
        profileVO.setTopicCount(integer);
        System.out.println(profileVO.getTopicCount());
        profileVO.setFollowerCount(
                bmsFollowMapper.selectCount(
                        new LambdaQueryWrapper<BmsFollow>().eq(BmsFollow::getParentId,id)));
        System.out.println("关注数：粉丝数"+profileVO.getFollowerCount());
        //        将umsUser对象 与 profileV0对象中相同属性的值拷贝给 profiV0,不一致的就不会拷贝
        BeanUtils.copyProperties(umsUser,profileVO);

        return profileVO;
    }
}
