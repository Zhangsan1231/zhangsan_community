package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.model.entity.BmsBillboard;
import org.springframework.stereotype.Repository;

//mybatis-plus 继承BaseMapper
@Repository //表明这是一个实体
public interface BmsBillboardMapper extends BaseMapper<BmsBillboard> {
}
