package com.zptc.gx.vo.menu;

import java.util.List;

import com.zptc.gx.permission.entity.Menu;

public class MenuVO1 {
	private Long id;
	
    private String menuStr;

    private String menuNum;
    
    private Long parentId;
    
    private String parentStr;

    private String parentNum;

    private String url;
    
    private boolean hasSubMenu;
    
    private List<MenuVO1> subMenuList;
    
    private Integer level;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentStr() {
		return parentStr;
	}

	public void setParentStr(String parentStr) {
		this.parentStr = parentStr;
	}

	public String getParentNum() {
		return parentNum;
	}

	public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
