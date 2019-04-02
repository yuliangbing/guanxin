package com.zptc.gx.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.permission.entity.Role;
import com.zptc.gx.permission.mapper.RoleMapper;
import com.zptc.gx.permission.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int addRole(Role role){
		return roleMapper.insertSelective(role);
	}
	@Override
	public int modifyRole(Role role){
		return roleMapper.updateByPrimaryKeySelective(role);
	}
	@Override
	public int deleteRoleById(Long id){
		return roleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Role findRoleById(Long id){
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}
}
