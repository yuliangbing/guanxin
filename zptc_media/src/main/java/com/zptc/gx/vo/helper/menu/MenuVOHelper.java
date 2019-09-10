package com.zptc.gx.vo.helper.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.vo.menu.MenuVO1;

public class MenuVOHelper {
	public static MenuVO1 getMenuVO1FromMenu(Menu menu) {
		MenuVO1 menuVO1 = new MenuVO1();
		menuVO1.setId(menu.getId());
		menuVO1.setMenuNum(menu.getMenuNum());
		menuVO1.setMenuStr(menu.getMenuStr());
		menuVO1.setParentId(menu.getParentId());
		menuVO1.setUrl(menu.getUrl());
		menuVO1.setParentNum(menu.getParentNum());
		menuVO1.setParentStr(menu.getParentStr());
		menuVO1.setLevel(menu.getLevel());
		menuVO1.setIcon(menu.getIcon());
		return menuVO1;
	}
	
	public static List<MenuVO1> getMenuVO1ListFromMenuList(List<Menu> menuList){
		List<MenuVO1> menuVO1List = new ArrayList<MenuVO1>();
		if (!CollectionUtils.isEmpty(menuList)) {
			for (Menu menu : menuList) {
				MenuVO1 menuVO1 = getMenuVO1FromMenu(menu);
				menuVO1List.add(menuVO1);
			}
		}
		return menuVO1List;
	}
}
