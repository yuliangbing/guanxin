package com.zptc.gx.permission.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addZptcUser(ZptcUser zptcUser){
		return zptcUserMapper.insertSelective(zptcUser);
	}
	@Override
	public int modifyZptcUser(ZptcUser zptcUser){
		return zptcUserMapper.updateByPrimaryKeySelective(zptcUser);
	}
	@Override
	public int deleteZptcUserById(Long id){
		return zptcUserMapper.deleteByPrimaryKey(id);
	}
	@Override
	public ZptcUser findZptcUserById(Long id){
		ZptcUser zptcUser = zptcUserMapper.selectByPrimaryKey(id);
		return zptcUser;
	}
	@Override
	public List<ZptcUser> findByParam(Map<String, Object> par) {
		// TODO Auto-generated method stub
		return zptcUserMapper.findByParam(par);
	}
}
