package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeachingAssetsCategory;

public interface TeachingAssetsCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingAssetsCategory record);

    int insertSelective(TeachingAssetsCategory record);

    TeachingAssetsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingAssetsCategory record);

    int updateByPrimaryKey(TeachingAssetsCategory record);
//软删除
	int updateByPrimaryKeyDel(TeachingAssetsCategory teachingAssetsCategory);
//获取列表
	List<TeachingAssetsCategory> getTeachingAssetsCategoryList(Map<String, Object> data);
//分页数据
	int selectCounts(Map<String, Object> count);
}