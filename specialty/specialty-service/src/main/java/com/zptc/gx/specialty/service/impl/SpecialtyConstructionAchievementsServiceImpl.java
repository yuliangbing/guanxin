package com.zptc.gx.specialty.service.impl;

import java.util.List;

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
	public int addSpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements){
		return specialtyConstructionAchievementsMapper.insertSelective(specialtyConstructionAchievements);
	}
	@Override
	public int modifySpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements){
		return specialtyConstructionAchievementsMapper.updateByPrimaryKeySelective(specialtyConstructionAchievements);
	}
	@Override
	public int deleteSpecialtyConstructionAchievementsById(Long id){
		return specialtyConstructionAchievementsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyConstructionAchievements findSpecialtyConstructionAchievementsById(Long id){
		SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsMapper.selectByPrimaryKey(id);
		return specialtyConstructionAchievements;
	}
	@Override
	public List<SpecialtyConstructionAchievements> getSpecialtyIdList(Long specialtyId) {
		// TODO Auto-generated method stub
		return specialtyConstructionAchievementsMapper.getSpecialtyIdList(specialtyId);
	}
	@Override
	public int modifySpecialtyConstructionAchievementsKey(
			SpecialtyConstructionAchievements specialtyConstructionAchievements) {
		// TODO Auto-generated method stub
		return specialtyConstructionAchievementsMapper.updateByPrimaryKeySelective(specialtyConstructionAchievements);
	}
}
