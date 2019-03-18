package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.OtherAchievements;
import com.zptc.gx.specialty.mapper.OtherAchievementsMapper;
import com.zptc.gx.specialty.service.OtherAchievementsService;

@Component
public class OtherAchievementsServiceImpl implements OtherAchievementsService {

	@Autowired
	private OtherAchievementsMapper otherAchievementsMapper;

	@Override
	public void addOtherAchievements(OtherAchievements otherAchievements){
		otherAchievementsMapper.insertSelective(otherAchievements);
	}
	@Override
	public void modifyOtherAchievements(OtherAchievements otherAchievements){
		otherAchievementsMapper.updateByPrimaryKeySelective(otherAchievements);
	}
	@Override
	public void deleteOtherAchievementsById(Long id){
		otherAchievementsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OtherAchievements findOtherAchievementsById(Long id){
		OtherAchievements otherAchievements = otherAchievementsMapper.selectByPrimaryKey(id);
		return otherAchievements;
	}
}
