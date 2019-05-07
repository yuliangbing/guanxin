package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addSpecialtyProfile(SpecialtyProfile specialtyProfile){
		return specialtyProfileMapper.insertSelective(specialtyProfile);
	}
	@Override
	public int modifySpecialtyProfile(SpecialtyProfile specialtyProfile){
		return specialtyProfileMapper.updateByPrimaryKeySelective(specialtyProfile);
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
	@Override
	public List<SpecialtyProfile> getSpecialtyProfileList(Object data) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.getSpecialtyProfileList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> counts) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.selectCounts(counts);
	}
	
	@Override
	public int modifSpecialtyFilesDel(SpecialtyProfile specialtyProfile) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.updateByPrimaryKeyDel(specialtyProfile);
	}
}
