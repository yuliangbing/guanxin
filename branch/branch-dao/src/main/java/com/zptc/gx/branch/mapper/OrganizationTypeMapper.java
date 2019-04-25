package com.zptc.gx.branch.mapper;

import com.zptc.gx.branch.entity.OrganizationType;

public interface OrganizationTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrganizationType record);

    int insertSelective(OrganizationType record);

    OrganizationType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationType record);

    int updateByPrimaryKey(OrganizationType record);
}