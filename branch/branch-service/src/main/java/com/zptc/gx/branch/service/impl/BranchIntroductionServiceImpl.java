package com.zptc.gx.branch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
//	软删除
	@Override
	@Transactional
	public int deleteBranchIntroductionById(BranchIntroduction branchIntroduction){
		return branchIntroductionMapper.deleteBranchIntroductionById(branchIntroduction);
	}
	@Override
	public BranchIntroduction findBranchIntroductionById(Long id){
		BranchIntroduction branchIntroduction = branchIntroductionMapper.selectByPrimaryKey(id);
		return branchIntroduction;
	}
	@Override
	public List<BranchIntroduction> getBranchText(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return branchIntroductionMapper.getBranchText(data);
	}
}
