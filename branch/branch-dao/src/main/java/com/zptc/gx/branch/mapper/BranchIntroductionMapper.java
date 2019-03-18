package com.zptc.gx.branch.mapper;

import com.zptc.gx.branch.entity.BranchIntroduction;

public interface BranchIntroductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BranchIntroduction record);

    int insertSelective(BranchIntroduction record);

    BranchIntroduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BranchIntroduction record);

    int updateByPrimaryKey(BranchIntroduction record);
}