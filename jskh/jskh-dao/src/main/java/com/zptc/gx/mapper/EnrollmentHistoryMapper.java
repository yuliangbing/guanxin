package com.zptc.gx.mapper;

import com.zptc.gx.entity.EnrollmentHistory;

public interface EnrollmentHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnrollmentHistory record);

    int insertSelective(EnrollmentHistory record);

    EnrollmentHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnrollmentHistory record);

    int updateByPrimaryKey(EnrollmentHistory record);
}