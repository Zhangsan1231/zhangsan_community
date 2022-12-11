package com.zhang.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.common.api.ApiResult;
import com.zhang.model.dto.LoginDTO;
import com.zhang.model.dto.RegisterDTO;
import com.zhang.model.entity.BmsBillboard;
import com.zhang.model.entity.BmsPost;
import com.zhang.model.entity.UmsUser;
import com.zhang.service.IBmsBillboardService;
import com.zhang.service.IBmsPostService;
import com.zhang.service.IUmsUserService;
import com.zhang.service.impl.IBmsPostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhang.jwt.JwtUtil.USER_NAME;

@Api(tags = "社区：用户管理")
@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController {

    @Resource
    private IUmsUserService umsUserService;
    @Resource
    private IBmsPostService bmsPostService;
    @ApiOperation("用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ApiResult<Map<String,Object>> register(@Valid @RequestBody RegisterDTO registerDTO) {
        UmsUser umsUser = umsUserService.executeRegister(registerDTO);
        if(ObjectUtils.isEmpty(umsUser))
            return ApiResult.failed("账号注册失败");
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("user",umsUser);
        return ApiResult.success(map);
    }
    @ApiOperation("用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ApiResult<Map<String,String>> register(@Valid @RequestBody LoginDTO loginDTO) {
        String token = umsUserService.executeLogin(loginDTO);
        System.out.println(token);
        if(ObjectUtils.isEmpty(token))
            return ApiResult.failed("账号或者密码错误");
        HashMap<String, String> map = new HashMap<>(16);
        map.put("token",token);
        return ApiResult.success(map,"登录成功");
    }

    @ApiOperation("将用户的信息反馈给前端")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
//    从请求头中找到已经解析好了的信息中获取用户名 并将值传递给username
    public ApiResult<UmsUser> getUser(@RequestHeader(value = USER_NAME) String  username){
        UmsUser name = umsUserService.getUserByUserName(username);
        System.out.println(name);
        return ApiResult.success(name);
    }
    @ApiOperation("注销")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ApiResult<UmsUser> logout(){
        return ApiResult.success(null,"注销成功");

    }
    @ApiOperation("根据用户名进行模糊查询并分页显示")
    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        UmsUser user = umsUserService.getUserByUserName(username);
        Assert.notNull(user, "用户不存在");
        Page<BmsPost> page = bmsPostService.page(new Page<>(pageNo, size),
                new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getUserId, user.getId()));
        map.put("user", user);
        map.put("topics", page);
        return ApiResult.success(map);
    }
    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ApiResult<UmsUser> updateUser(@RequestBody UmsUser umsUser) {
        umsUserService.updateById(umsUser);
        return ApiResult.success(umsUser);
    }
}
