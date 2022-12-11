package com.zhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.entity.BmsTip;

//mybatis-plus继承IService
public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
