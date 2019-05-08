 package com.zptc.gx.branch.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public int modifyOrganizationType(OrganizationType organizationType){
		return organizationTypeMapper.updateByPrimaryKeySelective(organizationType);
	}
	
	
	@Override
	@Transactional//事务回滚
	public int delOrganizationTypeById(OrganizationType organizationType){
		return organizationTypeMapper.delOrganizationTypeById(organizationType);
	}
	
	@Override
	public OrganizationType findOrganizationTypeById(Long id){
		OrganizationType organizationType = organizationTypeMapper.selectByPrimaryKey(id);
		return organizationType;
	}
	@Override
	public List<OrganizationType> getOrganizationTypeList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return organizationTypeMapper.getOrganizationType(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return organizationTypeMapper.selectCounts(count);
	}
	
}
