package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zhang.model.entity.BmsTip;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTipMapper extends BaseMapper<BmsTip> {
    BmsTip getRandomTip();
}
