package com.zptc.gx.mapper;

import com.zptc.gx.entity.Specialty;

public interface SpecialtyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specialty record);

    int insertSelective(Specialty record);

    Specialty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKey(Specialty record);
}