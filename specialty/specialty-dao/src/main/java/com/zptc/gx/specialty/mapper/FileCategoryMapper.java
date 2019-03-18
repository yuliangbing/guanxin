package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.FileCategory;

public interface FileCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FileCategory record);

    int insertSelective(FileCategory record);

    FileCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileCategory record);

    int updateByPrimaryKey(FileCategory record);
}