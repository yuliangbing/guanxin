package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyFilesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyFiles record);

    int insertSelective(SpecialtyFiles record);

    SpecialtyFiles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyFiles record);

    int updateByPrimaryKey(SpecialtyFiles record);
}