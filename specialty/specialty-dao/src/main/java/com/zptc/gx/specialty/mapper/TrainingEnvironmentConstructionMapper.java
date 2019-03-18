package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;

public interface TrainingEnvironmentConstructionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrainingEnvironmentConstruction record);

    int insertSelective(TrainingEnvironmentConstruction record);

    TrainingEnvironmentConstruction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrainingEnvironmentConstruction record);

    int updateByPrimaryKey(TrainingEnvironmentConstruction record);
}