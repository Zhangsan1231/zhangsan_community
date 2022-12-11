package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.mapper.BmsTipMapper;
import com.zhang.model.entity.BmsTip;
import com.zhang.service.IBmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//ServiceImpl<BmsBillboardMapper, BmsBillboard> 这个方法需要两个类，一个是继承了mapper类，一个是实体类
@Service
@Slf4j
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper, BmsTip>
        implements IBmsTipService {
    @Override
    public BmsTip getRandomTip() {
        BmsTip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("tip转化失败");
        }
        return todayTip;
    }
}
