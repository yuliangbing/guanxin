package com.zptc.gx.permission.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.ZptcUser;

public interface ZptcUserService {

	public int addZptcUser(ZptcUser zptcUser);

	public int modifyZptcUser(ZptcUser zptcUser);

	public int deleteZptcUserById(Long id);

	public ZptcUser findZptcUserById(Long id);
	
	public List<ZptcUser> findByParam(Map<String, Object> par);
//获取列表
	public List<ZptcUser> getZptcUser(Map<String, Object> data);
//统计条数
	public int selectCounts(Map<String, Object> count);
//软删除，改变stauts
	public int modifyZptcUserDel(ZptcUser zptcUser);
}
