package com.zptc.gx.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.mapper.ZptcUserMapper;
import com.zptc.gx.permission.service.ZptcUserService;

@Component
public class ZptcUserServiceImpl implements ZptcUserService {

	@Autowired
	private ZptcUserMapper zptcUserMapper;

	@Override
	public void addZptcUser(ZptcUser zptcUser){
		zptcUserMapper.insertSelective(zptcUser);
	}
	@Override
	public void modifyZptcUser(ZptcUser zptcUser){
		zptcUserMapper.updateByPrimaryKeySelective(zptcUser);
	}
	@Override
	public void deleteZptcUserById(Long id){
		zptcUserMapper.deleteByPrimaryKey(id);
	}
	@Override
	public ZptcUser findZptcUserById(Long id){
		ZptcUser zptcUser = zptcUserMapper.selectByPrimaryKey(id);
		return zptcUser;
	}
}
