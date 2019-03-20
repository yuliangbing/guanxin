package com.zptc.gx.permission.mapper;

import com.zptc.gx.permission.entity.ZptcUser;

public interface ZptcUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ZptcUser record);

    int insertSelective(ZptcUser record);

    ZptcUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZptcUser record);

    int updateByPrimaryKey(ZptcUser record);
}