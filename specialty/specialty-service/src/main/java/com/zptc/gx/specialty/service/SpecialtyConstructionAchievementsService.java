package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;

public interface SpecialtyConstructionAchievementsService {

	public void addSpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements);

	public void modifySpecialtyConstructionAchievements(SpecialtyConstructionAchievements specialtyConstructionAchievements);

	public void deleteSpecialtyConstructionAchievementsById(Long id);

	public SpecialtyConstructionAchievements findSpecialtyConstructionAchievementsById(Long id);

}
