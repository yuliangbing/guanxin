package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.Patent;

public interface PatentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);
}