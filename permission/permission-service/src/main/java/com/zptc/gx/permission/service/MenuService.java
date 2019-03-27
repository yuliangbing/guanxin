package com.zptc.gx.permission.service;

import java.util.List;

import com.zptc.gx.permission.entity.Menu;

public interface MenuService {

	public void addMenu(Menu menu);

	public void modifyMenu(Menu menu);

	public void deleteMenuById(Long id);

	public Menu findMenuById(Long id);
	
	public List<Menu> findMenuByRoleId(Long roleId);

}
