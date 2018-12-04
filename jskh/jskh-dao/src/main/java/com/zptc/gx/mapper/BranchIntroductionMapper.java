package com.zptc.gx.mapper;

import com.zptc.gx.entity.BranchIntroduction;

public interface BranchIntroductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BranchIntroduction record);

    int insertSelective(BranchIntroduction record);

    BranchIntroduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BranchIntroduction record);

    int updateByPrimaryKey(BranchIntroduction record);
}