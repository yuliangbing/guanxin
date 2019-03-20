package com.zptc.gx.permission.service;

import com.zptc.gx.permission.entity.ZptcUser;

public interface ZptcUserService {

	public void addZptcUser(ZptcUser zptcUser);

	public void modifyZptcUser(ZptcUser zptcUser);

	public void deleteZptcUserById(Long id);

	public ZptcUser findZptcUserById(Long id);

}
