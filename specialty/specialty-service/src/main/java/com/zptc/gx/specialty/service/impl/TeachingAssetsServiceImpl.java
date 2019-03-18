package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.TeachingAssets;
import com.zptc.gx.specialty.mapper.TeachingAssetsMapper;
import com.zptc.gx.specialty.service.TeachingAssetsService;

@Component
public class TeachingAssetsServiceImpl implements TeachingAssetsService {

	@Autowired
	private TeachingAssetsMapper teachingAssetsMapper;

	@Override
	public void addTeachingAssets(TeachingAssets teachingAssets){
		teachingAssetsMapper.insertSelective(teachingAssets);
	}
	@Override
	public void modifyTeachingAssets(TeachingAssets teachingAssets){
		teachingAssetsMapper.updateByPrimaryKeySelective(teachingAssets);
	}
	@Override
	public void deleteTeachingAssetsById(Long id){
		teachingAssetsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public TeachingAssets findTeachingAssetsById(Long id){
		TeachingAssets teachingAssets = teachingAssetsMapper.selectByPrimaryKey(id);
		return teachingAssets;
	}
}
