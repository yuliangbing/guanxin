package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.TeachingAssetsCategory;
import com.zptc.gx.specialty.mapper.TeachingAssetsCategoryMapper;
import com.zptc.gx.specialty.service.TeachingAssetsCategoryService;

@Component
public class TeachingAssetsCategoryServiceImpl implements TeachingAssetsCategoryService {

	@Autowired
	private TeachingAssetsCategoryMapper teachingAssetsCategoryMapper;

	@Override
	public int addTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory){
		return teachingAssetsCategoryMapper.insertSelective(teachingAssetsCategory);
	}
	@Override
	public int modifyTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory){
		return teachingAssetsCategoryMapper.updateByPrimaryKeySelective(teachingAssetsCategory);
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
//	软删除改变staus
	@Override
	@Transactional//事务回滚
	public int modifyTeachingAssetsCategoryDel(TeachingAssetsCategory teachingAssetsCategory) {
		// TODO Auto-generated method stub
		return teachingAssetsCategoryMapper.updateByPrimaryKeyDel(teachingAssetsCategory);
	}
	@Override
	public List<TeachingAssetsCategory> getTeachingAssetsCategoryList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return teachingAssetsCategoryMapper.getTeachingAssetsCategoryList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return teachingAssetsCategoryMapper.selectCounts(count);
	}
}
