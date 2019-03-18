package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.Issues;

public interface IssuesService {

	public void addIssues(Issues issues);

	public void modifyIssues(Issues issues);

	public void deleteIssuesById(Long id);

	public Issues findIssuesById(Long id);

}
