package com.zptc.gx.permission.mapper;

import java.util.List;

import com.zptc.gx.permission.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> findMenuByRoleId(Long roleId);
}