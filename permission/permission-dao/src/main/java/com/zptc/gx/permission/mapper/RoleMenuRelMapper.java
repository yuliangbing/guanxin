package com.zptc.gx.permission.mapper;

import com.zptc.gx.permission.entity.RoleMenuRel;

public interface RoleMenuRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenuRel record);

    int insertSelective(RoleMenuRel record);

    RoleMenuRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenuRel record);

    int updateByPrimaryKey(RoleMenuRel record);
}