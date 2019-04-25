package com.zptc.gx.branch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
