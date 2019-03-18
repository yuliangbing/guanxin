package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.GraduateHistory;
import com.zptc.gx.specialty.mapper.GraduateHistoryMapper;
import com.zptc.gx.specialty.service.GraduateHistoryService;

@Component
public class GraduateHistoryServiceImpl implements GraduateHistoryService {

	@Autowired
	private GraduateHistoryMapper graduateHistoryMapper;

	@Override
	public void addGraduateHistory(GraduateHistory graduateHistory){
		graduateHistoryMapper.insertSelective(graduateHistory);
	}
	@Override
	public void modifyGraduateHistory(GraduateHistory graduateHistory){
		graduateHistoryMapper.updateByPrimaryKeySelective(graduateHistory);
	}
	@Override
	public void deleteGraduateHistoryById(Long id){
		graduateHistoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public GraduateHistory findGraduateHistoryById(Long id){
		GraduateHistory graduateHistory = graduateHistoryMapper.selectByPrimaryKey(id);
		return graduateHistory;
	}
}
