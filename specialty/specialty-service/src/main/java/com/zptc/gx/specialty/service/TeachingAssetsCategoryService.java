package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeachingAssetsCategory;

public interface TeachingAssetsCategoryService {

	public int addTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory);
//修改
	public int modifyTeachingAssetsCategory(TeachingAssetsCategory teachingAssetsCategory);

	public void deleteTeachingAssetsCategoryById(Long id);

	public TeachingAssetsCategory findTeachingAssetsCategoryById(Long id);
//改变staus软删除方法
	public int modifyTeachingAssetsCategoryDel(TeachingAssetsCategory teachingAssetsCategory);
//	获取教学资产分类信息
	public List<TeachingAssetsCategory> getTeachingAssetsCategoryList(Map<String, Object> data);
//分页数据
	public int selectCounts(Map<String, Object> count);

}
