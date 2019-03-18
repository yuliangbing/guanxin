package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.OutstandingGraduateHistory;

public interface OutstandingGraduateHistoryService {

	public void addOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory);

	public void modifyOutstandingGraduateHistory(OutstandingGraduateHistory outstandingGraduateHistory);

	public void deleteOutstandingGraduateHistoryById(Long id);

	public OutstandingGraduateHistory findOutstandingGraduateHistoryById(Long id);

}
