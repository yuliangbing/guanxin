package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeachingAssets;

public interface TeachingAssetsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingAssets record);

    int insertSelective(TeachingAssets record);

    TeachingAssets selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingAssets record);

    int updateByPrimaryKey(TeachingAssets record);
//软删除
	int updateByPrimaryKeyDel(TeachingAssets record);
//获取列表数据
	List<TeachingAssets> getTeachingAssetsList(Map<String, Object> data);
//获取count数
	int selectCounts(Map<String, Object> count);
}