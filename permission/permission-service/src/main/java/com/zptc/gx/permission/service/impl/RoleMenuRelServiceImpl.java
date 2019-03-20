package com.zptc.gx.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.permission.entity.RoleMenuRel;
import com.zptc.gx.permission.mapper.RoleMenuRelMapper;
import com.zptc.gx.permission.service.RoleMenuRelService;

@Component
public class RoleMenuRelServiceImpl implements RoleMenuRelService {

	@Autowired
	private RoleMenuRelMapper roleMenuRelMapper;

	@Override
	public void addRoleMenuRel(RoleMenuRel roleMenuRel){
		roleMenuRelMapper.insertSelective(roleMenuRel);
	}
	@Override
	public void modifyRoleMenuRel(RoleMenuRel roleMenuRel){
		roleMenuRelMapper.updateByPrimaryKeySelective(roleMenuRel);
	}
	@Override
	public void deleteRoleMenuRelById(Long id){
		roleMenuRelMapper.deleteByPrimaryKey(id);
	}
	@Override
	public RoleMenuRel findRoleMenuRelById(Long id){
		RoleMenuRel roleMenuRel = roleMenuRelMapper.selectByPrimaryKey(id);
		return roleMenuRel;
	}
}
