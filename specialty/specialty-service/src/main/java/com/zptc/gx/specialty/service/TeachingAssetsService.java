package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.TeachingAssets;

public interface TeachingAssetsService {

	public void addTeachingAssets(TeachingAssets teachingAssets);

	public void modifyTeachingAssets(TeachingAssets teachingAssets);

	public void deleteTeachingAssetsById(Long id);

	public TeachingAssets findTeachingAssetsById(Long id);

}
