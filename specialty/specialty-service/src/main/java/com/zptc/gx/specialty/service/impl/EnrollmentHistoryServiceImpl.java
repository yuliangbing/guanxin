package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.EnrollmentHistory;
import com.zptc.gx.specialty.mapper.EnrollmentHistoryMapper;
import com.zptc.gx.specialty.service.EnrollmentHistoryService;

@Component
public class EnrollmentHistoryServiceImpl implements EnrollmentHistoryService {

	@Autowired
	private EnrollmentHistoryMapper enrollmentHistoryMapper;

	@Override
	public void addEnrollmentHistory(EnrollmentHistory enrollmentHistory){
		enrollmentHistoryMapper.insertSelective(enrollmentHistory);
	}
	@Override
	public void modifyEnrollmentHistory(EnrollmentHistory enrollmentHistory){
		enrollmentHistoryMapper.updateByPrimaryKeySelective(enrollmentHistory);
	}
	@Override
	public void deleteEnrollmentHistoryById(Long id){
		enrollmentHistoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public EnrollmentHistory findEnrollmentHistoryById(Long id){
		EnrollmentHistory enrollmentHistory = enrollmentHistoryMapper.selectByPrimaryKey(id);
		return enrollmentHistory;
	}
}
