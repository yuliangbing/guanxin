package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addGraduateHistory(GraduateHistory graduateHistory){
		return graduateHistoryMapper.insertSelective(graduateHistory);
	}
	@Override
	public int modifyGraduateHistory(GraduateHistory graduateHistory){
		return graduateHistoryMapper.updateByPrimaryKeySelective(graduateHistory);
	}
	@Override
	public int deleteGraduateHistoryById(Long id){
		return graduateHistoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public GraduateHistory findGraduateHistoryById(Long id){
		GraduateHistory graduateHistory = graduateHistoryMapper.selectByPrimaryKey(id);
		return graduateHistory;
	}
	@Override
	public List<GraduateHistory> getGraduateHistoryList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return graduateHistoryMapper.GraduateHistoryList(data);
	}
	@Override
	public int Counts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return graduateHistoryMapper.selectCounts(count);
	}
	@Override
	public int modifSpecialtyDel(GraduateHistory graduateHistory) {
		// TODO Auto-generated method stub
		return graduateHistoryMapper.updateDel(graduateHistory);
	}
}
