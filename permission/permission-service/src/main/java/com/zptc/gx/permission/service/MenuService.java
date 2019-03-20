package com.zptc.gx.permission.service;

import com.zptc.gx.permission.entity.Menu;

public interface MenuService {

	public void addMenu(Menu menu);

	public void modifyMenu(Menu menu);

	public void deleteMenuById(Long id);

	public Menu findMenuById(Long id);

}
