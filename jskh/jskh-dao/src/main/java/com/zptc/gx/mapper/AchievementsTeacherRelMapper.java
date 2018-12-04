package com.zptc.gx.mapper;

import com.zptc.gx.entity.AchievementsTeacherRel;

public interface AchievementsTeacherRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AchievementsTeacherRel record);

    int insertSelective(AchievementsTeacherRel record);

    AchievementsTeacherRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AchievementsTeacherRel record);

    int updateByPrimaryKey(AchievementsTeacherRel record);
}