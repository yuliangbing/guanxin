package com.zptc.gx.mapper;

import com.zptc.gx.entity.FileCategory;

public interface FileCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FileCategory record);

    int insertSelective(FileCategory record);

    FileCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileCategory record);

    int updateByPrimaryKey(FileCategory record);
}