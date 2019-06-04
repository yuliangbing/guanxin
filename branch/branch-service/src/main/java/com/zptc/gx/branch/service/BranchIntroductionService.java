package com.zptc.gx.branch.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.BranchIntroduction;

public interface BranchIntroductionService {

	public int addBranchIntroduction(BranchIntroduction branchIntroduction);

	public int modifyBranchIntroduction(BranchIntroduction branchIntroduction);

	public int deleteBranchIntroductionById(BranchIntroduction branchIntroduction);

	public BranchIntroduction findBranchIntroductionById(Long id);
//获取文本信息
	public List<BranchIntroduction> getBranchText(Map<String, Object> data);
//status查询
	List<BranchIntroduction> getBranchStatus(Map<String, Object> data);


}
