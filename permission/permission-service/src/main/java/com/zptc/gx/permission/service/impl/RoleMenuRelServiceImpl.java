package com.zptc.gx.permission.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
	@Override
	public List<Long> getMenuIdListByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return roleMenuRelMapper.getMenuIdListByRoleId(roleId);
	}
	@Override
	@Transactional
	public int updateRoleMenuRels(Map<String, Object> par) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Long userId = (Long) par.get("userId");
		String username = (String) par.get("username");
		
		int count = 0;
		Long roleId = (Long) par.get("roleId");
		count += roleMenuRelMapper.deleteByRoleId(roleId);
		
		List<Long> newMenuIdList = (List<Long>) par.get("newMenuIdList");
		if (!CollectionUtils.isEmpty(newMenuIdList)) {
			for (Long menuId : newMenuIdList) {
				RoleMenuRel roleMenuRel = new RoleMenuRel();
				roleMenuRel.setMenuId(menuId);
				roleMenuRel.setRoleId(roleId);
				roleMenuRel.setStatus(1);
				roleMenuRel.setCreateId(userId);
				roleMenuRel.setCreateTime(date);
				roleMenuRel.setCreateUser(username);
				
				count += roleMenuRelMapper.insertSelective(roleMenuRel);
			}
		}
		
		return count;
	}
}
