package com.zptc.gx.branch.mapper;

import java.util.List;

import com.zptc.gx.branch.entity.OrganizationType;


public interface OrganizationTypeMapper {
    int deleteByPrimaryKey(Long id);
    
    int delOrganizationTypeById(OrganizationType organizationType );

    int insert(OrganizationType record);

    int insertSelective(OrganizationType record);

    OrganizationType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationType record);

    int updateByPrimaryKey(OrganizationType record);
    
    List<OrganizationType> getOrganizationType(Object data);
}