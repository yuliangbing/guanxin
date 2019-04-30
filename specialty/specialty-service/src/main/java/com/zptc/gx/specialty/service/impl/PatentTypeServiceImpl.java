package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.PatentType;
import com.zptc.gx.specialty.mapper.PatentTypeMapper;
import com.zptc.gx.specialty.service.PatentTypeService;

@Component
public class PatentTypeServiceImpl implements PatentTypeService {

	@Autowired
	private PatentTypeMapper patentTypeMapper;

	@Override
	public int addPatentType(PatentType patentType){
		return patentTypeMapper.insertSelective(patentType);
	}
	@Override
	public int modifyPatentType(PatentType patentType){
		return patentTypeMapper.updateByPrimaryKeySelective(patentType);
	}
	@Override
	public int deletePatentTypeById(Long id){
		return patentTypeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public PatentType findPatentTypeById(Long id){
		PatentType patentType = patentTypeMapper.selectByPrimaryKey(id);
		return patentType;
	}
}
