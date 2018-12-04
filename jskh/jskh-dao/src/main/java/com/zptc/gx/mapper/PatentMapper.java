package com.zptc.gx.mapper;

import com.zptc.gx.entity.Patent;

public interface PatentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);
}