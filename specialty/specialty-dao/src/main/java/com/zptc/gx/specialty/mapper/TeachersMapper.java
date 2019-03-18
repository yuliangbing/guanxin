package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.Teachers;

public interface TeachersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
}