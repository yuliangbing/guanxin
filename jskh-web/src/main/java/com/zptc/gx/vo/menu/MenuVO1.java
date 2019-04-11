package com.zptc.gx.vo.menu;

import java.util.List;

import com.zptc.gx.permission.entity.Menu;

public class MenuVO1 {
	private Long id;
	
    private String menuStr;

    private String menuNum;

    private String url;
    
    private boolean hasSubMenu;
    
    private List<MenuVO1> subMenuList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuStr() {
		return menuStr;
	}

	public void setMenuStr(String menuStr) {
		this.menuStr = menuStr;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isHasSubMenu() {
		return hasSubMenu;
	}

	public void setHasSubMenu(boolean hasSubMenu) {
		this.hasSubMenu = hasSubMenu;
	}

	public List<MenuVO1> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<MenuVO1> subMenuList) {
		this.subMenuList = subMenuList;
	}
}
