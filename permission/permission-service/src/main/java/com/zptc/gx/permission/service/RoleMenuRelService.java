package com.zptc.gx.permission.service;

import com.zptc.gx.permission.entity.RoleMenuRel;

public interface RoleMenuRelService {

	public void addRoleMenuRel(RoleMenuRel roleMenuRel);

	public void modifyRoleMenuRel(RoleMenuRel roleMenuRel);

	public void deleteRoleMenuRelById(Long id);

	public RoleMenuRel findRoleMenuRelById(Long id);

}
