package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.OtherAchievements;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface OtherAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OtherAchievements record);

    int insertSelective(OtherAchievements record);

    OtherAchievements selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OtherAchievements record);

    int updateByPrimaryKey(OtherAchievements record);
    
    List<OtherAchievements> getOtherAchievementsList(Map<String, Object> data);

	int Counts(Map<String, Object> count);

	//根据status修改状态（删除）
	int DelOtherAchievements(OtherAchievements otherAchievements);
}