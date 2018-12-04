package com.zptc.gx.mapper;

import com.zptc.gx.entity.GraduateHistory;

public interface GraduateHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GraduateHistory record);

    int insertSelective(GraduateHistory record);

    GraduateHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GraduateHistory record);

    int updateByPrimaryKey(GraduateHistory record);
}