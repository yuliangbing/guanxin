package com.zptc.gx.specialty.service.impl;

import java.util.List;

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
	public int addSpecialty(Specialty specialty){
		return specialtyMapper.insertSelective(specialty);
	}
	@Override
	public int modifySpecialty(Specialty specialty){
		return specialtyMapper.updateByPrimaryKeySelective(specialty);
	}
	@Override
	public int deleteSpecialtyById(Long id){
		return specialtyMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Specialty findSpecialtyById(Long id){
		Specialty specialty = specialtyMapper.selectByPrimaryKey(id);
		return specialty;
	}
	@Override
	public List<Specialty> findSpecialtyByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return specialtyMapper.findSpecialtyByRoleId(roleId);
	}
	@Override
	public List<Specialty> getSpecialtyIdList(Long specialtyId) {
		// TODO Auto-generated method stub
		return specialtyMapper.getSpecialtyIdList(specialtyId);
	}
}
