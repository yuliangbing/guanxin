package com.zptc.gx.vo.menu;

import java.util.List;

public class MenuTree {
	private String title;
	
	private String value;
	
	private boolean checked;
	
	private boolean disabled;
	
	private List<MenuTree> data;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<MenuTree> getData() {
		return data;
	}

	public void setData(List<MenuTree> data) {
		this.data = data;
	}
}
