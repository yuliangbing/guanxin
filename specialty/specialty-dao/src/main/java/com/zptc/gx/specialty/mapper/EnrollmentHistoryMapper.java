package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.EnrollmentHistory;

public interface EnrollmentHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnrollmentHistory record);

    int insertSelective(EnrollmentHistory record);

    EnrollmentHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnrollmentHistory record);

    int updateByPrimaryKey(EnrollmentHistory record);
}