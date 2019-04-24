package com.zptc.gx.permission.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryRoleList(Map<String, Object> par);
    
    int countRoleList(Map<String, Object> par);
    
    int setNotDefault(Role record);
}