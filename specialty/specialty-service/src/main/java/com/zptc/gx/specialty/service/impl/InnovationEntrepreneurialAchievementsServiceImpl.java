package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements){
		return innovationEntrepreneurialAchievementsMapper.insertSelective(innovationEntrepreneurialAchievements);
	}
	@Override
	public int modifyInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements){
		return innovationEntrepreneurialAchievementsMapper.updateByPrimaryKeySelective(innovationEntrepreneurialAchievements);
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
	@Override
	public List<InnovationEntrepreneurialAchievements> getIEAchievementsList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return innovationEntrepreneurialAchievementsMapper.IEAchievementsList(data);
	}
	@Override
	public int Counts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return innovationEntrepreneurialAchievementsMapper.Counts(count);
	}
	@Override
	public int dellIEAchievements(InnovationEntrepreneurialAchievements achievements) {
		// TODO Auto-generated method stub
		return innovationEntrepreneurialAchievementsMapper.updateDel(achievements);
	}
}
