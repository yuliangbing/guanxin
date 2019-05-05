package com.zptc.gx.permission.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public int deleteMenuById(Long id){
		int result = 0;
		
		//删除子菜单
		result += menuMapper.deleteByParentId(id);
		
		//删除菜单
		result += menuMapper.deleteByPrimaryKey(id);
		return result;
	}
	@Override
	public Menu findMenuById(Long id){
		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}
	@Override
	public List<Menu> findUserMenu(Map<String, Object> par) {
		// TODO Auto-generated method stub
		return menuMapper.findUserMenu(par);
	}
	@Override
	public List<Menu> queryMenuList(Map<String, Object> par) {
		// TODO Auto-generated method stub
		return menuMapper.queryMenuList(par);
	}
	@Override
	public int findMaxLevel() {
		// TODO Auto-generated method stub
		return menuMapper.findMaxLevel();
	}
}
