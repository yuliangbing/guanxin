package com.zptc.gx.branch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.branch.entity.OrganizationType;
import com.zptc.gx.branch.mapper.OrganizationTypeMapper;
import com.zptc.gx.branch.service.OrganizationTypeService;

@Component
public class OrganizationTypeServiceImpl implements OrganizationTypeService {

	@Autowired
	private OrganizationTypeMapper organizationTypeMapper;

	@Override
	public int addOrganizationType(OrganizationType organizationType){
		return organizationTypeMapper.insertSelective(organizationType);
	}
	@Override
	public int modifyOrganizationType(OrganizationType organizationType){
		return organizationTypeMapper.updateByPrimaryKeySelective(organizationType);
	}
	@Override
	public int deleteOrganizationTypeById(Long id){
		return organizationTypeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public OrganizationType findOrganizationTypeById(Long id){
		OrganizationType organizationType = organizationTypeMapper.selectByPrimaryKey(id);
		return organizationType;
	}
}
