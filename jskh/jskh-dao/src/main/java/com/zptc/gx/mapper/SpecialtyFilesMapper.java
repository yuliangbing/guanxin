package com.zptc.gx.mapper;

import com.zptc.gx.entity.SpecialtyFiles;

public interface SpecialtyFilesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyFiles record);

    int insertSelective(SpecialtyFiles record);

    SpecialtyFiles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyFiles record);

    int updateByPrimaryKey(SpecialtyFiles record);
}