package com.zptc.gx.permission.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.RoleMenuRel;

public interface RoleMenuRelService {

	public void addRoleMenuRel(RoleMenuRel roleMenuRel);

	public void modifyRoleMenuRel(RoleMenuRel roleMenuRel);

	public void deleteRoleMenuRelById(Long id);

	public RoleMenuRel findRoleMenuRelById(Long id);
	
	public List<Long> getMenuIdListByRoleId(Long roleId);
	
	public int updateRoleMenuRels(Map<String, Object> par);

}
