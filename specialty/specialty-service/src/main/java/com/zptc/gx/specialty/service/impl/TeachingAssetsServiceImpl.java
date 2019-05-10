package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.TeachingAssets;
import com.zptc.gx.specialty.mapper.TeachingAssetsMapper;
import com.zptc.gx.specialty.service.TeachingAssetsService;

@Component
public class TeachingAssetsServiceImpl implements TeachingAssetsService {

	@Autowired
	private TeachingAssetsMapper teachingAssetsMapper;

	@Override
	public int addTeachingAssets(TeachingAssets teachingAssets){
		return teachingAssetsMapper.insertSelective(teachingAssets);
	}
	@Override
	public int modifyTeachingAssets(TeachingAssets teachingAssets){
		return teachingAssetsMapper.updateByPrimaryKeySelective(teachingAssets);
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
//	软删除
	@Override
	@Transactional
	public int modifTeachingAssetsDel(TeachingAssets teachingAssets) {
		// TODO Auto-generated method stub
		return teachingAssetsMapper.updateByPrimaryKeyDel(teachingAssets);
	}
	@Override
	public List<TeachingAssets> getTeachingAssetsList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return teachingAssetsMapper.getTeachingAssetsList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return teachingAssetsMapper.selectCounts(count);
	}
	
}
