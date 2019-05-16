package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.EnrollmentHistory;

public interface EnrollmentHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnrollmentHistory record);

    int insertSelective(EnrollmentHistory record);

    EnrollmentHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnrollmentHistory record);

    int updateByPrimaryKey(EnrollmentHistory record);
//改变stauts,软删除
	int updateByStautsDel(EnrollmentHistory enrollmentHistory);
//获取列表数据
	List<EnrollmentHistory> getEnrollmentHistoryList(Map<String, Object> data);
//统计数据条数
	int selectCounts(Map<String, Object> count);
}