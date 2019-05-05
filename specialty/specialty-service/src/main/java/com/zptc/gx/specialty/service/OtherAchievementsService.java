package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.OtherAchievements;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface OtherAchievementsService {

	public int addOtherAchievements(OtherAchievements otherAchievements);

	public int modifyOtherAchievements(OtherAchievements otherAchievements);

	public int deleteOtherAchievementsById(Long id);

	public OtherAchievements findOtherAchievementsById(Long id);
	
	//获取列表数据
	public List<OtherAchievements> getOtherAchievementsList(Map<String, Object> data);
	
	//统计
	public int selectCounts(Map<String, Object> count);
	
	//根据status修改状态（删除）
	public int modifOtherAchievementsDel(OtherAchievements otherAchievements);
}
