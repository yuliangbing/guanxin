package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.Issues;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.mapper.IssuesMapper;
import com.zptc.gx.specialty.service.IssuesService;

@Component
public class IssuesServiceImpl implements IssuesService {

	@Autowired
	private IssuesMapper issuesMapper;

	@Override
	public int addIssues(Issues issues){
		return issuesMapper.insertSelective(issues);
	}
	@Override
	public void modifyIssues(Issues issues){
		issuesMapper.updateByPrimaryKeySelective(issues);
	}
	@Override
	public void deleteIssuesById(Long id){
		issuesMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Issues findIssuesById(Long id){
		Issues issues = issuesMapper.selectByPrimaryKey(id);
		return issues;
	}
	@Override
	public List<Issues> getIssuesList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return issuesMapper.getIssuesList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return issuesMapper.selectCounts(count);
	}
	@Override
	public int modifIssuesDel(Issues issues) {
		// TODO Auto-generated method stub
		return issuesMapper.updateByPrimaryKeyDel(issues);
	}
	@Override
	public int modifyIssuesKey(Issues issues) {
		// TODO Auto-generated method stub
		return issuesMapper.updateByPrimaryKey(issues);
	}
}
