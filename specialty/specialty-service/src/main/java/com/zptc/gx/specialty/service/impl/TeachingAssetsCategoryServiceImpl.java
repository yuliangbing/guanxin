package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.TeachingAssetsCategory;
import com.zptc.gx.specialty.mapper.TeachingAssetsCategoryMapper;
import com.zptc.gx.specialty.service.TeachingAssetsCategoryService;

@Component
public class TeachingAssetsCategoryServiceImpl implements TeachingAssetsCategoryService {

	@Autowired
	private TeachingAssetsCategoryMapper teachingAssetsCategoryMapper;

	@Override
	public void addTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory){
		teachingAssetsCategoryMapper.insertSelective(teachingAssetsCategory);
	}
	@Override
	public void modifyTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory){
		teachingAssetsCategoryMapper.updateByPrimaryKeySelective(teachingAssetsCategory);
	}
	@Override
	public void deleteTeachingAssetsCategoryById(Long id){
		teachingAssetsCategoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public TeachingAssetsCategory findTeachingAssetsCategoryById(Long id){
		TeachingAssetsCategory teachingAssetsCategory = teachingAssetsCategoryMapper.selectByPrimaryKey(id);
		return teachingAssetsCategory;
	}
}
