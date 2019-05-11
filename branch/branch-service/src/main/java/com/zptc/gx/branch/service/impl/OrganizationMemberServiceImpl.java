package com.zptc.gx.branch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.branch.entity.OrganizationMember;
import com.zptc.gx.branch.mapper.OrganizationMemberMapper;
import com.zptc.gx.branch.service.OrganizationMemberService;

@Component
public class OrganizationMemberServiceImpl implements OrganizationMemberService {

	@Autowired
	private OrganizationMemberMapper organizationMemberMapper;

	@Override
	public int addOrganizationMember(OrganizationMember organizationMember){
		return organizationMemberMapper.insertSelective(organizationMember);
	}
	@Override
	@Transactional
	public int modifyOrganizationMember(OrganizationMember organizationMember){
		return organizationMemberMapper.updateByPrimaryKeySelective(organizationMember);
	}
	@Override
	public int deleteOrganizationMemberById(Long id){
		return organizationMemberMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OrganizationMember findOrganizationMemberById(Long id){
		OrganizationMember organizationMember = organizationMemberMapper.selectByPrimaryKey(id);
		return organizationMember;
	}
	@Override
	public List<OrganizationMember> getOrganizationMemberList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return organizationMemberMapper.getOrganizationMember(data);
	}
	@Override
	@Transactional//事务回滚
	public int delOrganizationMemberById(OrganizationMember organizationMember) {
		// TODO Auto-generated method stub
		return organizationMemberMapper.delOrganizationMemberById(organizationMember);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return organizationMemberMapper.selectCounts(count);
	}
}
