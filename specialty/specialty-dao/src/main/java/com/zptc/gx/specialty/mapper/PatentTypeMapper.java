package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.PatentType;

public interface PatentTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PatentType record);

    int insertSelective(PatentType record);

    PatentType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PatentType record);

    int updateByPrimaryKey(PatentType record);
}