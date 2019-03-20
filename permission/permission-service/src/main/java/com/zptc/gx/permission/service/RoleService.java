package com.zptc.gx.permission.service;

import com.zptc.gx.permission.entity.Role;

public interface RoleService {

	public void addRole(Role role);

	public void modifyRole(Role role);

	public void deleteRoleById(Long id);

	public Role findRoleById(Long id);

}
