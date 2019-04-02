package com.zptc.gx.permission.service;

import java.util.List;

import com.zptc.gx.permission.entity.Menu;

public interface MenuService {

	public int addMenu(Menu menu);

	public int modifyMenu(Menu menu);

	public int deleteMenuById(Long id);

	public Menu findMenuById(Long id);
	
	public List<Menu> findMenuByRoleId(Long roleId);

}
