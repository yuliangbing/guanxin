package com.zptc.gx.mapper;

import com.zptc.gx.entity.TrainingEnvironmentConstruction;

public interface TrainingEnvironmentConstructionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrainingEnvironmentConstruction record);

    int insertSelective(TrainingEnvironmentConstruction record);

    TrainingEnvironmentConstruction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrainingEnvironmentConstruction record);

    int updateByPrimaryKey(TrainingEnvironmentConstruction record);
}