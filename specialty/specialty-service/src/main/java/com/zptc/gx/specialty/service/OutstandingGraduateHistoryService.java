package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.OutstandingGraduateHistory;

public interface OutstandingGraduateHistoryService {

	public int addOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory);

	public int modifyOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory);

	public int deleteOutstandingGraduateHistoryById(Long id);

	public OutstandingGraduateHistory findOutstandingGraduateHistoryById(Long id);

	public List<OutstandingGraduateHistory> getOutstandingGraduateHistoryList(Map<String, Object> data);

	public int Counts(Map<String, Object> count);

	public int delOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory);

}
