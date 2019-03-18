package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.TeachingAssets;

public interface TeachingAssetsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingAssets record);

    int insertSelective(TeachingAssets record);

    TeachingAssets selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingAssets record);

    int updateByPrimaryKey(TeachingAssets record);
}