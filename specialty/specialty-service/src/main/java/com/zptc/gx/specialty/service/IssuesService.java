package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Issues;

public interface IssuesService {

	public void addIssues(Issues issues);

	public void modifyIssues(Issues issues);

	public void deleteIssuesById(Long id);

	public Issues findIssuesById(Long id);
	
	//获取课程的全部数据
	public List<Issues> getIssuesList(Map<String, Object> data);

	//统计数据条数
	public int selectCounts(Map<String, Object> count);

}
