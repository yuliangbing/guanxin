package com.zptc.gx.branch.service;

import com.zptc.gx.branch.entity.BranchIntroduction;

public interface BranchIntroductionService {

	public int addBranchIntroduction(BranchIntroduction branchIntroduction);

	public int modifyBranchIntroduction(BranchIntroduction branchIntroduction);

	public int deleteBranchIntroductionById(Long id);

	public BranchIntroduction findBranchIntroductionById(Long branchId);


}
