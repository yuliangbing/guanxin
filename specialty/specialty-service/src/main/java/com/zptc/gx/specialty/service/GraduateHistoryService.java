package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.GraduateHistory;

public interface GraduateHistoryService {

	public int addGraduateHistory(GraduateHistory graduateHistory);

	public int modifyGraduateHistory(GraduateHistory graduateHistory);

	public int deleteGraduateHistoryById(Long id);

	public GraduateHistory findGraduateHistoryById(Long id);

	public List<GraduateHistory> getGraduateHistoryList(Map<String, Object> data);

	public int Counts(Map<String, Object> count);

	public int modifSpecialtyDel(GraduateHistory graduateHistory);

}
