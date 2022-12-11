package com.zhang.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhang.common.api.ApiResult;
import com.zhang.model.entity.BmsBillboard;
import com.zhang.model.entity.BmsTip;
import com.zhang.service.IBmsBillboardService;
import com.zhang.service.IBmsTipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Api(tags = "社区：每日一句")
@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController{

    @Resource
    private IBmsTipService bmsTipService;
    @ApiOperation("随机展示一条")
    @GetMapping("/today")
    public ApiResult<BmsTip> getRandomTip(){
        BmsTip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
