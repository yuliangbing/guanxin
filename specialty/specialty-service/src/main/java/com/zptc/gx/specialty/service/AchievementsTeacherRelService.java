package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.AchievementsTeacherRel;

public interface AchievementsTeacherRelService {

	public void addAchievementsTeacherRel(AchievementsTeacherRel achievementsTeacherRel);

	public void modifyAchievementsTeacherRel(AchievementsTeacherRel achievementsTeacherRel);

	public void deleteAchievementsTeacherRelById(Long id);

	public AchievementsTeacherRel findAchievementsTeacherRelById(Long id);

}
