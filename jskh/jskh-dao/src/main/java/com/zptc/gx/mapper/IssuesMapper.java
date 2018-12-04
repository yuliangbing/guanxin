package com.zptc.gx.mapper;

import com.zptc.gx.entity.Issues;

public interface IssuesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Issues record);

    int insertSelective(Issues record);

    Issues selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Issues record);

    int updateByPrimaryKey(Issues record);
}