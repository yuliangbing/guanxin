package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface SpecialtyConstructionMeasuresMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionMeasures record);

    int insertSelective(SpecialtyConstructionMeasures record);

    SpecialtyConstructionMeasures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyConstructionMeasures record);

    int updateByPrimaryKey(SpecialtyConstructionMeasures record);
}