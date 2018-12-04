package com.zptc.gx.mapper;

import com.zptc.gx.entity.InnovationEntrepreneurialAchievements;

public interface InnovationEntrepreneurialAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InnovationEntrepreneurialAchievements record);

    int insertSelective(InnovationEntrepreneurialAchievements record);

    InnovationEntrepreneurialAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InnovationEntrepreneurialAchievements record);

    int updateByPrimaryKey(InnovationEntrepreneurialAchievements record);
}