package com.zptc.gx.specialty.mapper;

import java.util.List;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;

public interface SpecialtyConstructionAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionAchievements record);

    int insertSelective(SpecialtyConstructionAchievements record);

    SpecialtyConstructionAchievements selectByPrimaryKey(Long id);
    //带if
    int updateByPrimaryKeySelective(SpecialtyConstructionAchievements record);
    //不带if
    int updateByPrimaryKey(SpecialtyConstructionAchievements record);
    
    //根据specialtyId查询专业全部数据(不需要specialtyId)
	List<SpecialtyConstructionAchievements> getSpecialtyIdList(Long specialtyId);
}