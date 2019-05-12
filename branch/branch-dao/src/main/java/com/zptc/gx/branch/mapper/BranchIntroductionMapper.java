package com.zptc.gx.branch.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.BranchIntroduction;

public interface BranchIntroductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BranchIntroduction record);

    int insertSelective(BranchIntroduction record);

    BranchIntroduction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BranchIntroduction record);

    int updateByPrimaryKey(BranchIntroduction record);
//软删除
	int deleteBranchIntroductionById(BranchIntroduction branchIntroduction);
//获取文本数据
	List<BranchIntroduction> getBranchText(Map<String, Object> data);
}