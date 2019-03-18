package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.mapper.SpecialtyMapper;
import com.zptc.gx.specialty.service.SpecialtyService;

@Component
public class SpecialtyServiceImpl implements SpecialtyService {

	@Autowired
	private SpecialtyMapper specialtyMapper;

	@Override
	public void addSpecialty(Specialty specialty){
		specialtyMapper.insertSelective(specialty);
	}
	@Override
	public void modifySpecialty(Specialty specialty){
		specialtyMapper.updateByPrimaryKeySelective(specialty);
	}
	@Override
	public void deleteSpecialtyById(Long id){
		specialtyMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Specialty findSpecialtyById(Long id){
		Specialty specialty = specialtyMapper.selectByPrimaryKey(id);
		return specialty;
	}
}
