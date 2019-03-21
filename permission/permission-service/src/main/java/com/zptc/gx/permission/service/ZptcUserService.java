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

}
