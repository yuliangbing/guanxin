package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;
import com.zptc.gx.specialty.mapper.SchoolEnterpriseCooperationMapper;
import com.zptc.gx.specialty.service.SchoolEnterpriseCooperationService;

@Component
public class SchoolEnterpriseCooperationServiceImpl implements SchoolEnterpriseCooperationService {

	@Autowired
	private SchoolEnterpriseCooperationMapper schoolEnterpriseCooperationMapper;

	@Override
	public void addSchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation){
		schoolEnterpriseCooperationMapper.insertSelective(schoolEnterpriseCooperation);
	}
	@Override
	public void modifySchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation){
		schoolEnterpriseCooperationMapper.updateByPrimaryKeySelective(schoolEnterpriseCooperation);
	}
	@Override
	public void deleteSchoolEnterpriseCooperationById(Long id){
		schoolEnterpriseCooperationMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SchoolEnterpriseCooperation findSchoolEnterpriseCooperationById(Long id){
		SchoolEnterpriseCooperation schoolEnterpriseCooperation = schoolEnterpriseCooperationMapper.selectByPrimaryKey(id);
		return schoolEnterpriseCooperation;
	}
}
