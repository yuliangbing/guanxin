package com.zptc.gx.permission.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> findUserMenu(Map<String, Object> par);
    
    List<Menu> queryMenuList(Map<String, Object> par);
    
    int deleteByParentId(Long parentId);
}