package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.OtherAchievements;

public interface OtherAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OtherAchievements record);

    int insertSelective(OtherAchievements record);

    OtherAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OtherAchievements record);

    int updateByPrimaryKey(OtherAchievements record);
}