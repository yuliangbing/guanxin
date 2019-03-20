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
	public void addRole(Role role){
		roleMapper.insertSelective(role);
	}
	@Override
	public void modifyRole(Role role){
		roleMapper.updateByPrimaryKeySelective(role);
	}
	@Override
	public void deleteRoleById(Long id){
		roleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Role findRoleById(Long id){
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}
}
