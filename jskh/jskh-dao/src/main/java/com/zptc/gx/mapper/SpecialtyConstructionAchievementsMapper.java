package com.zptc.gx.mapper;

import com.zptc.gx.entity.SpecialtyConstructionAchievements;

public interface SpecialtyConstructionAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionAchievements record);

    int insertSelective(SpecialtyConstructionAchievements record);

    SpecialtyConstructionAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyConstructionAchievements record);

    int updateByPrimaryKey(SpecialtyConstructionAchievements record);
}