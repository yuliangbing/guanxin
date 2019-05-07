package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.OutstandingGraduateHistory;

public interface OutstandingGraduateHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutstandingGraduateHistory record);

    int insertSelective(OutstandingGraduateHistory record);

    OutstandingGraduateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutstandingGraduateHistory record);

    int updateByPrimaryKey(OutstandingGraduateHistory record);

	List<OutstandingGraduateHistory> OutstandingGraduateHistoryList(Map<String, Object> data);

	int selectCounts(Map<String, Object> count);

	int updateDel(OutstandingGraduateHistory outstandingGraduateHistory);
}