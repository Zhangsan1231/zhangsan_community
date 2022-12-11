package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.model.entity.BmsTip;
import com.zhang.model.entity.UmsUser;
import org.springframework.stereotype.Repository;

@Repository //表明这是一个实体
public interface UmsUserMapper extends  BaseMapper<UmsUser> {

}