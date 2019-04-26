package com.zptc.gx.permission.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.permission.entity.Role;
import com.zptc.gx.permission.mapper.RoleMapper;
import com.zptc.gx.permission.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;// Autowired：spring注解自动注入roleMapper

	@Override
	public int addRole(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public int modifyRole(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int deleteRoleById(Long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role findRoleById(Long id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	@Override
	public List<Role> queryRoleList(Map<String, Object> par) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleList(par);
	}

	@Override
	public int countRoleList(Map<String, Object> par) {
		// TODO Auto-generated method stub
		return roleMapper.countRoleList(par);
		// 1.可以按住ctrl+左键点击countRoleList的Declaration查看mapper接口
		// 2.可以按住ctrl+shift+R打开文件搜索窗口，输入roleMapper可以搜索到文件，点击打开RoleMapper.xml文件，编写sql
	}

	@Override
	@Transactional
	public int setDefault(Role role) {
		int result = 0;
		// 置为都不是默认
		result += roleMapper.setNotDefault(role);
		// 置为默认
		result += roleMapper.updateByPrimaryKeySelective(role);
		return result;
	}
}
