package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.SpecialtyProfile;

public interface SpecialtyProfileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyProfile record);

    int insertSelective(SpecialtyProfile record);

    SpecialtyProfile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyProfile record);

    int updateByPrimaryKey(SpecialtyProfile record);
}