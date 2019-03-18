package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.AchievementsTeacherRel;
import com.zptc.gx.specialty.mapper.AchievementsTeacherRelMapper;
import com.zptc.gx.specialty.service.AchievementsTeacherRelService;

@Component
public class AchievementsTeacherRelServiceImpl implements AchievementsTeacherRelService {

	@Autowired
	private AchievementsTeacherRelMapper achievementsTeacherRelMapper;

	@Override
	public void addAchievementsTeacherRel(AchievementsTeacherRel achievementsTeacherRel){
		achievementsTeacherRelMapper.insertSelective(achievementsTeacherRel);
	}
	@Override
	public void modifyAchievementsTeacherRel(AchievementsTeacherRel achievementsTeacherRel){
		achievementsTeacherRelMapper.updateByPrimaryKeySelective(achievementsTeacherRel);
	}
	@Override
	public void deleteAchievementsTeacherRelById(Long id){
		achievementsTeacherRelMapper.deleteByPrimaryKey(id);
	}
	@Override
	public AchievementsTeacherRel findAchievementsTeacherRelById(Long id){
		AchievementsTeacherRel achievementsTeacherRel = achievementsTeacherRelMapper.selectByPrimaryKey(id);
		return achievementsTeacherRel;
	}
}
