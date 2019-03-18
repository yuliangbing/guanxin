package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.mapper.SpecialtyProfileMapper;
import com.zptc.gx.specialty.service.SpecialtyProfileService;

@Component
public class SpecialtyProfileServiceImpl implements SpecialtyProfileService {

	@Autowired
	private SpecialtyProfileMapper specialtyProfileMapper;

	@Override
	public void addSpecialtyProfile(SpecialtyProfile specialtyProfile){
		specialtyProfileMapper.insertSelective(specialtyProfile);
	}
	@Override
	public void modifySpecialtyProfile(SpecialtyProfile specialtyProfile){
		specialtyProfileMapper.updateByPrimaryKeySelective(specialtyProfile);
	}
	@Override
	public void deleteSpecialtyProfileById(Long id){
		specialtyProfileMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyProfile findSpecialtyProfileById(Long id){
		SpecialtyProfile specialtyProfile = specialtyProfileMapper.selectByPrimaryKey(id);
		return specialtyProfile;
	}
}
