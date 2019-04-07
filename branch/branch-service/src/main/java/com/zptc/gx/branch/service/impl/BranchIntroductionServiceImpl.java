package com.zptc.gx.branch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.branch.entity.BranchIntroduction;
import com.zptc.gx.branch.mapper.BranchIntroductionMapper;
import com.zptc.gx.branch.service.BranchIntroductionService;

@Component
public class BranchIntroductionServiceImpl implements BranchIntroductionService {

	@Autowired
	private BranchIntroductionMapper branchIntroductionMapper;

	@Override
	public int addBranchIntroduction(BranchIntroduction branchIntroduction){
		return branchIntroductionMapper.insertSelective(branchIntroduction);
	}
	@Override
	public int  modifyBranchIntroduction(BranchIntroduction branchIntroduction){
		return branchIntroductionMapper.updateByPrimaryKeySelective(branchIntroduction);
	}
	@Override
	public int deleteBranchIntroductionById(Long id){
		return branchIntroductionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public BranchIntroduction findBranchIntroductionById(Long id){
		BranchIntroduction branchIntroduction = branchIntroductionMapper.selectByPrimaryKey(id);
		return branchIntroduction;
	}
}
