package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.EnrollmentHistory;

public interface EnrollmentHistoryService {

	public int addEnrollmentHistory(EnrollmentHistory enrollmentHistory);

	public int modifyEnrollmentHistory(EnrollmentHistory enrollmentHistory);

	public void deleteEnrollmentHistoryById(Long id);

	public EnrollmentHistory findEnrollmentHistoryById(Long id);
//软删除，改变status
	public int modifyEnrollmentHistoryDel(EnrollmentHistory enrollmentHistory);
//获取列表数据
	public List<EnrollmentHistory> getEnrollmentHistoryList(Map<String, Object> data);
//统计数据条数
	public int selectCounts(Map<String, Object> count);

}
