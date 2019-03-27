package com.zptc.gx.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.mapper.MenuMapper;
import com.zptc.gx.permission.service.MenuService;

@Component
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public void addMenu(Menu menu){
		menuMapper.insertSelective(menu);
	}
	@Override
	public void modifyMenu(Menu menu){
		menuMapper.updateByPrimaryKeySelective(menu);
	}
	@Override
	public void deleteMenuById(Long id){
		menuMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Menu findMenuById(Long id){
		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}
	@Override
	public List<Menu> findMenuByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return menuMapper.findMenuByRoleId(roleId);
	}
}
