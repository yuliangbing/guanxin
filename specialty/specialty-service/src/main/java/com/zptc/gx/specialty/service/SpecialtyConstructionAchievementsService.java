package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyConstructionAchievementsService {
	//添加
	public int addSpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements);
	//修改专业
	//带if条件
	public int modifySpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements);
	//不带if条件
	public int modifySpecialtyConstructionAchievementsKey(SpecialtyConstructionAchievements specialtyConstructionAchievements);
	//删除专业
	public int deleteSpecialtyConstructionAchievementsById(Long id);
	//根据id查询专业数据
	public SpecialtyConstructionAchievements findSpecialtyConstructionAchievementsById(Long id);
	//根据specialtyId查询专业全部数据(不需要specialtyId)
	public List<SpecialtyConstructionAchievements> getSpecialtyAchievementsList(Map<String, Object> data);
	//统计数据条数
	public int selectCounts(Map<String, Object> count);
	//根据status修改状态（删除）
	public int modifSpecialtyFilesDel(SpecialtyConstructionAchievements specialtyConstructionAchievements);
}
