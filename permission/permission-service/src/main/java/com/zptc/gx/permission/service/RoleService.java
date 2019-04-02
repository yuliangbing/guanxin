package com.zptc.gx.permission.service;

import com.zptc.gx.permission.entity.Role;

public interface RoleService {

	public int addRole(Role role);

	public int modifyRole(Role role);

	public int deleteRoleById(Long id);

	public Role findRoleById(Long id);

}
