package com.zhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.mapper.BmsBillboardMapper;
import com.zhang.mapper.BmsPromotionMapper;
import com.zhang.model.entity.BmsBillboard;
import com.zhang.model.entity.BmsPromotion;
import com.zhang.service.IBmsBillboardService;
import com.zhang.service.IBmsPromotionService;
import org.springframework.stereotype.Service;

//ServiceImpl<BmsBillboardMapper, BmsBillboard> 这个方法需要两个类，一个是继承了mapper类，一个是实体类
@Service
public class IBmsPromotionServiceImpl extends ServiceImpl<BmsPromotionMapper, BmsPromotion>
implements IBmsPromotionService {
}
