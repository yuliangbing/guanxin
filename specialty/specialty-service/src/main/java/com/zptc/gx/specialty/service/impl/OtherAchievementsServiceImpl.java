package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addOtherAchievements(OtherAchievements otherAchievements){
		return otherAchievementsMapper.insertSelective(otherAchievements);
	}
	@Override
	public int modifyOtherAchievements(OtherAchievements otherAchievements){
		return otherAchievementsMapper.updateByPrimaryKeySelective(otherAchievements);
	}
	@Override
	public int deleteOtherAchievementsById(Long id){
		return otherAchievementsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OtherAchievements findOtherAchievementsById(Long id){
		OtherAchievements otherAchievements = otherAchievementsMapper.selectByPrimaryKey(id);
		return otherAchievements;
	}
	@Override
	public List<OtherAchievements> getOtherAchievementsList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return otherAchievementsMapper.getOtherAchievementsList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return otherAchievementsMapper.Counts(count);
	}
	@Override
	public int modifOtherAchievementsDel(OtherAchievements otherAchievements) {
		// TODO Auto-generated method stub
		return otherAchievementsMapper.DelOtherAchievements(otherAchievements);
	}
}
