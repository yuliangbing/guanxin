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
  //获取列表
	List<OrganizationMember> getOrganizationMember(Map<String, Object> data);
	//统计条数
	int selectCounts(Map<String, Object> count);
}