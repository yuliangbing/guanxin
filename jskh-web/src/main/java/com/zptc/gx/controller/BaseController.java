package com.zptc.gx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.service.MenuService;
import com.zptc.gx.vo.helper.menu.MenuVOHelper;
import com.zptc.gx.vo.menu.MenuVO1;

public class BaseController {

	private Logger logger = Logger.getLogger(BaseController.class);
	
	@Autowired
	private MenuService menuService;
	
	public static final Integer FLAG_SUCCESS = 0;// 请求响应成功
	public static final Integer FLAG_FAILED = 500;// 请求响应失败
	public static final Integer MENU_LEVEL = 0;// 第一层菜单
	
	public Map<String, Object> getMap(){
		return new HashMap<String, Object>();
	}
	
	public String getParam(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
	
	public void setSession(HttpServletRequest request, String name, Object sessionObj) {
		request.getSession().setAttribute(name, sessionObj);
	}
	
	//获取菜单列表
	public List<MenuVO1> getMenuVOList(List<Menu> menuList,int level){
		int nextLevel = level+1;
		List<MenuVO1> menuVOList = new ArrayList<>();
		for (Menu parentMenu : menuList) {
			MenuVO1 parentMenuVO = MenuVOHelper.getMenuVO1FromMenu(parentMenu);
			parentMenuVO.setLevel(level);
			Map<String, Object> menuPar = new HashMap<>();
			menuPar.put("parentId", parentMenu.getId());
			List<Menu> subMenuList = menuService.queryMenuList(menuPar);
			if (!CollectionUtils.isEmpty(subMenuList)) {
				parentMenuVO.setHasSubMenu(true);
				List<MenuVO1> subMenuVOList = getMenuVOList(subMenuList,nextLevel);
				parentMenuVO.setSubMenuList(subMenuVOList);
			} else {
				parentMenuVO.setHasSubMenu(false);
			}
			menuVOList.add(parentMenuVO);
		}
		return menuVOList;
	}
}
