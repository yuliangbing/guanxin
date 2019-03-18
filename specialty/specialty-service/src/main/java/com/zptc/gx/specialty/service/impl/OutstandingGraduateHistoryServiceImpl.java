package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.OutstandingGraduateHistory;
import com.zptc.gx.specialty.mapper.OutstandingGraduateHistoryMapper;
import com.zptc.gx.specialty.service.OutstandingGraduateHistoryService;

@Component
public class OutstandingGraduateHistoryServiceImpl implements OutstandingGraduateHistoryService {

	@Autowired
	private OutstandingGraduateHistoryMapper outstandingGraduateHistoryMapper;

	@Override
	public void addOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory){
		outstandingGraduateHistoryMapper.insertSelective(outstandingGraduateHistory);
	}
	@Override
	public void modifyOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory){
		outstandingGraduateHistoryMapper.updateByPrimaryKeySelective(outstandingGraduateHistory);
	}
	@Override
	public void deleteOutstandingGraduateHistoryById(Long id){
		outstandingGraduateHistoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OutstandingGraduateHistory findOutstandingGraduateHistoryById(Long id){
		OutstandingGraduateHistory outstandingGraduateHistory = outstandingGraduateHistoryMapper.selectByPrimaryKey(id);
		return outstandingGraduateHistory;
	}
}
