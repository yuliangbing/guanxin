package com.zptc.gx.permission.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.Role;

public interface RoleService {

	public int addRole(Role role);

	public int modifyRole(Role role);

	public int deleteRoleById(Long id);

	public Role findRoleById(Long id);
	
	public List<Role> queryRoleList(Map<String, Object> par);
	
	public int countRoleList(Map<String, Object> par);
	
	public int setDefault(Role role);

}
