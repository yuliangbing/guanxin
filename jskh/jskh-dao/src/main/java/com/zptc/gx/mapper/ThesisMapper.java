package com.zptc.gx.mapper;

import com.zptc.gx.entity.Thesis;

public interface ThesisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    Thesis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
}