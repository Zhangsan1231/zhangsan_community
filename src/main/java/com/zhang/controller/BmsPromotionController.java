package com.zhang.controller;



import com.zhang.common.api.ApiResult;
import com.zhang.model.entity.BmsPromotion;

import com.zhang.service.IBmsPromotionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Api(tags = "社区：广告")
@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController{

    @Resource
    private IBmsPromotionService bmsPromotionService;
    @ApiOperation("广告展示")
    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> getList(){
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }
}
