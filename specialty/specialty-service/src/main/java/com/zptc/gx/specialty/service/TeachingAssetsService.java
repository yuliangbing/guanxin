package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeachingAssets;

public interface TeachingAssetsService {

	public int addTeachingAssets(TeachingAssets teachingAssets);

	public int modifyTeachingAssets(TeachingAssets teachingAssets);

	public void deleteTeachingAssetsById(Long id);

	public TeachingAssets findTeachingAssetsById(Long id);
//软删除
	public int modifTeachingAssetsDel(TeachingAssets teachingAssets);
//获取列表
	public List<TeachingAssets> getTeachingAssetsList(Map<String, Object> data);
//获取count数量
	public int selectCounts(Map<String, Object> count);

}
