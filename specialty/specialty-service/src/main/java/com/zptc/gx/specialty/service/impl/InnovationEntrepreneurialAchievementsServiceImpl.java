package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;
import com.zptc.gx.specialty.mapper.InnovationEntrepreneurialAchievementsMapper;
import com.zptc.gx.specialty.service.InnovationEntrepreneurialAchievementsService;

@Component
public class InnovationEntrepreneurialAchievementsServiceImpl implements InnovationEntrepreneurialAchievementsService {

	@Autowired
	private InnovationEntrepreneurialAchievementsMapper innovationEntrepreneurialAchievementsMapper;

	@Override
	public void addInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements){
		innovationEntrepreneurialAchievementsMapper.insertSelective(innovationEntrepreneurialAchievements);
	}
	@Override
	public void modifyInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements){
		innovationEntrepreneurialAchievementsMapper.updateByPrimaryKeySelective(innovationEntrepreneurialAchievements);
	}
	@Override
	public void deleteInnovationEntrepreneurialAchievementsById(Long id){
		innovationEntrepreneurialAchievementsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public InnovationEntrepreneurialAchievements findInnovationEntrepreneurialAchievementsById(Long id){
		InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements = innovationEntrepreneurialAchievementsMapper.selectByPrimaryKey(id);
		return innovationEntrepreneurialAchievements;
	}
}
