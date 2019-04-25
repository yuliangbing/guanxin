package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Issues;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface IssuesService {

	public int addIssues(Issues issues);

	public void modifyIssues(Issues issues);

	public void deleteIssuesById(Long id);

	public Issues findIssuesById(Long id);
	//不带if条件
	public int modifyIssuesKey(Issues issues);
	
	//获取课程的全部数据
	public List<Issues> getIssuesList(Map<String, Object> data);

	//统计数据条数
	public int selectCounts(Map<String, Object> count);
	
	//根据status修改状态（删除）
	public int modifIssuesDel(Issues issues);

}
