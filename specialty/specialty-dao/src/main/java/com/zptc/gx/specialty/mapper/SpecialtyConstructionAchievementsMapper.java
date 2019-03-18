package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;

public interface SpecialtyConstructionAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionAchievements record);

    int insertSelective(SpecialtyConstructionAchievements record);

    SpecialtyConstructionAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyConstructionAchievements record);

    int updateByPrimaryKey(SpecialtyConstructionAchievements record);
}