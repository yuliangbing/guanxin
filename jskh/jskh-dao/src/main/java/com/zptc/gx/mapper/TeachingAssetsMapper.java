package com.zptc.gx.mapper;

import com.zptc.gx.entity.TeachingAssets;

public interface TeachingAssetsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingAssets record);

    int insertSelective(TeachingAssets record);

    TeachingAssets selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingAssets record);

    int updateByPrimaryKey(TeachingAssets record);
}