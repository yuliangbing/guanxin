package com.zptc.gx.mapper;

import com.zptc.gx.entity.OutstandingGraduateHistory;

public interface OutstandingGraduateHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutstandingGraduateHistory record);

    int insertSelective(OutstandingGraduateHistory record);

    OutstandingGraduateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutstandingGraduateHistory record);

    int updateByPrimaryKey(OutstandingGraduateHistory record);
}