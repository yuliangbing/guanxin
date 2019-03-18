package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.TeachingAssetsCategory;

public interface TeachingAssetsCategoryService {

	public void addTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory);

	public void modifyTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory);

	public void deleteTeachingAssetsCategoryById(Long id);

	public TeachingAssetsCategory findTeachingAssetsCategoryById(Long id);

}
