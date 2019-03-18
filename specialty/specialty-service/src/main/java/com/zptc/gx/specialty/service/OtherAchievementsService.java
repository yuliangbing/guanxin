package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.OtherAchievements;

public interface OtherAchievementsService {

	public void addOtherAchievements(OtherAchievements otherAchievements);

	public void modifyOtherAchievements(OtherAchievements otherAchievements);

	public void deleteOtherAchievementsById(Long id);

	public OtherAchievements findOtherAchievementsById(Long id);

}
