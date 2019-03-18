package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.mapper.SpecialtyConstructionAchievementsMapper;
import com.zptc.gx.specialty.service.SpecialtyConstructionAchievementsService;

@Component
public class SpecialtyConstructionAchievementsServiceImpl implements SpecialtyConstructionAchievementsService {

	@Autowired
	private SpecialtyConstructionAchievementsMapper specialtyConstructionAchievementsMapper;

	@Override
	public void addSpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements){
		specialtyConstructionAchievementsMapper.insertSelective(specialtyConstructionAchievements);
	}
	@Override
	public void modifySpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements){
		specialtyConstructionAchievementsMapper.updateByPrimaryKeySelective(specialtyConstructionAchievements);
	}
	@Override
	public void deleteSpecialtyConstructionAchievementsById(Long id){
		specialtyConstructionAchievementsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyConstructionAchievements findSpecialtyConstructionAchievementsById(Long id){
		SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsMapper.selectByPrimaryKey(id);
		return specialtyConstructionAchievements;
	}
}
