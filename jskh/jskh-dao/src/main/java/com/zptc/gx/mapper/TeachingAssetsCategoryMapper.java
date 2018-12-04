package com.zptc.gx.mapper;

import com.zptc.gx.entity.TeachingAssetsCategory;

public interface TeachingAssetsCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingAssetsCategory record);

    int insertSelective(TeachingAssetsCategory record);

    TeachingAssetsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingAssetsCategory record);

    int updateByPrimaryKey(TeachingAssetsCategory record);
}