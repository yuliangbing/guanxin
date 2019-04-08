package com.zptc.gx.specialty.service;

import java.util.List;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;

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
	public List<SpecialtyConstructionAchievements> getSpecialtyIdList(Long specialtyId);

}
