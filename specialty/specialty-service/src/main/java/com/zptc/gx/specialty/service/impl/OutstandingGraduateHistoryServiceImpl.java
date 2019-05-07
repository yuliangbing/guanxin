package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory){
		return outstandingGraduateHistoryMapper.insertSelective(outstandingGraduateHistory);
	}
	@Override
	public int modifyOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory){
		return outstandingGraduateHistoryMapper.updateByPrimaryKeySelective(outstandingGraduateHistory);
	}
	@Override
	public int deleteOutstandingGraduateHistoryById(Long id){
		return outstandingGraduateHistoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OutstandingGraduateHistory findOutstandingGraduateHistoryById(Long id){
		OutstandingGraduateHistory outstandingGraduateHistory = outstandingGraduateHistoryMapper.selectByPrimaryKey(id);
		return outstandingGraduateHistory;
	}
	@Override
	public List<OutstandingGraduateHistory> getOutstandingGraduateHistoryList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return outstandingGraduateHistoryMapper.OutstandingGraduateHistoryList(data);
	}
	@Override
	public int Counts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return outstandingGraduateHistoryMapper.selectCounts(count);
	}
	@Override
	public int delOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory) {
		// TODO Auto-generated method stub
		return outstandingGraduateHistoryMapper.updateDel(outstandingGraduateHistory);
	}
}
