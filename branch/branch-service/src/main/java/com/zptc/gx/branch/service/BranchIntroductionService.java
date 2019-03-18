package com.zptc.gx.branch.service;

import com.zptc.gx.branch.entity.BranchIntroduction;

public interface BranchIntroductionService {

	public void addBranchIntroduction(BranchIntroduction branchIntroduction);

	public void modifyBranchIntroduction(BranchIntroduction branchIntroduction);

	public void deleteBranchIntroductionById(Long id);

	public BranchIntroduction findBranchIntroductionById(Long id);

}
