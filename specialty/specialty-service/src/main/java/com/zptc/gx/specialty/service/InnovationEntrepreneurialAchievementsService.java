package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;

public interface InnovationEntrepreneurialAchievementsService {

	public int addInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements);

	public int modifyInnovationEntrepreneurialAchievements(InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements);

	public void deleteInnovationEntrepreneurialAchievementsById(Long id);

	public InnovationEntrepreneurialAchievements findInnovationEntrepreneurialAchievementsById(Long id);

	public List<InnovationEntrepreneurialAchievements> getIEAchievementsList(Map<String, Object> data);

	public int Counts(Map<String, Object> count);

	public int dellIEAchievements(InnovationEntrepreneurialAchievements achievements);

}
