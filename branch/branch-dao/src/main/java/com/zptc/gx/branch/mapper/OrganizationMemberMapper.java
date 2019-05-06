package com.zptc.gx.branch.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.OrganizationMember;


public interface OrganizationMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationMember record);

    int insertSelective(OrganizationMember record);

    OrganizationMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationMember record);

    int updateByPrimaryKey(OrganizationMember record);
    
    int delOrganizationMemberById(OrganizationMember OrganizationMember );

	List<OrganizationMember> getOrganizationMember(Map<String, Object> data);
}