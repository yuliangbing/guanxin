package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;

public interface InnovationEntrepreneurialAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InnovationEntrepreneurialAchievements record);

    int insertSelective(InnovationEntrepreneurialAchievements record);

    InnovationEntrepreneurialAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InnovationEntrepreneurialAchievements record);

    int updateByPrimaryKey(InnovationEntrepreneurialAchievements record);

	List<InnovationEntrepreneurialAchievements> IEAchievementsList(Map<String, Object> data);

	int Counts(Map<String, Object> count);

	int updateDel(InnovationEntrepreneurialAchievements achievements);
}