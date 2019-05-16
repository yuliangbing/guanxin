package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.EnrollmentHistory;
import com.zptc.gx.specialty.mapper.EnrollmentHistoryMapper;
import com.zptc.gx.specialty.service.EnrollmentHistoryService;

@Component
public class EnrollmentHistoryServiceImpl implements EnrollmentHistoryService {

	@Autowired
	private EnrollmentHistoryMapper enrollmentHistoryMapper;

	@Override
	public int addEnrollmentHistory(EnrollmentHistory enrollmentHistory){
		return enrollmentHistoryMapper.insertSelective(enrollmentHistory);
	}
	@Override
	public int modifyEnrollmentHistory(EnrollmentHistory enrollmentHistory){
		return enrollmentHistoryMapper.updateByPrimaryKeySelective(enrollmentHistory);
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
//	软删除改变status
	@Override
	@Transactional//事务回滚
	public int modifyEnrollmentHistoryDel(EnrollmentHistory enrollmentHistory) {
		// TODO Auto-generated method stub
		return enrollmentHistoryMapper.updateByStautsDel(enrollmentHistory);
	}
//	获取列表数据
	@Override
	public List<EnrollmentHistory> getEnrollmentHistoryList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return enrollmentHistoryMapper.getEnrollmentHistoryList(data);
	}
//	统计数据条数
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return enrollmentHistoryMapper.selectCounts(count);
	}
}
