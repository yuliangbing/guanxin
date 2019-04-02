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
	public int addMenu(Menu menu){
		return menuMapper.insertSelective(menu);
	}
	@Override
	public int modifyMenu(Menu menu){
		return menuMapper.updateByPrimaryKeySelective(menu);
	}
	@Override
	public int deleteMenuById(Long id){
		return menuMapper.deleteByPrimaryKey(id);
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
