package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;

public interface InnovationEntrepreneurialAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InnovationEntrepreneurialAchievements record);

    int insertSelective(InnovationEntrepreneurialAchievements record);

    InnovationEntrepreneurialAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InnovationEntrepreneurialAchievements record);

    int updateByPrimaryKey(InnovationEntrepreneurialAchievements record);
}