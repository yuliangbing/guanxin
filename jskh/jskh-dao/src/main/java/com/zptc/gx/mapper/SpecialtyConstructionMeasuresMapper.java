package com.zptc.gx.mapper;

import com.zptc.gx.entity.SpecialtyConstructionMeasures;

public interface SpecialtyConstructionMeasuresMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionMeasures record);

    int insertSelective(SpecialtyConstructionMeasures record);

    SpecialtyConstructionMeasures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyConstructionMeasures record);

    int updateByPrimaryKey(SpecialtyConstructionMeasures record);
}