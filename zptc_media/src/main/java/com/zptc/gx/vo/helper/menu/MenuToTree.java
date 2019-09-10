package com.zptc.gx.vo.helper.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.vo.menu.MenuTree;

public class MenuToTree {
	public static MenuTree getMenuTreeFromMenu(Menu menu) {
		MenuTree menuTree = new MenuTree();
		menuTree.setTitle(menu.getMenuStr());
		menuTree.setValue(menu.getId().toString());
		return menuTree;
	}
	
	public static List<MenuTree> getMenuTreeListFromMenuList(List<Menu> menuList){
		List<MenuTree> menuTreeList = new ArrayList<MenuTree>();
		if (!CollectionUtils.isEmpty(menuList)) {
			for (Menu menu : menuList) {
				MenuTree menuTree = getMenuTreeFromMenu(menu);
				menuTreeList.add(menuTree);
			}
		}
		return menuTreeList;
	}
}
