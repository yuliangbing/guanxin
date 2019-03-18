package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.GraduateHistory;

public interface GraduateHistoryService {

	public void addGraduateHistory(GraduateHistory graduateHistory);

	public void modifyGraduateHistory(GraduateHistory graduateHistory);

	public void deleteGraduateHistoryById(Long id);

	public GraduateHistory findGraduateHistoryById(Long id);

}
