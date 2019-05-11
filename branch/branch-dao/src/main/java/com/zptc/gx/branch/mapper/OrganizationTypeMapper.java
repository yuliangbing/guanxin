package com.zptc.gx.branch.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.OrganizationType;


public interface OrganizationTypeMapper {
    int deleteByPrimaryKey(Long id);
    
    int delOrganizationTypeById(OrganizationType organizationType );

    int insert(OrganizationType record);

    int insertSelective(OrganizationType record);

    OrganizationType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrganizationType record);

    int updateByPrimaryKey(OrganizationType record);
//获取列表
    List<OrganizationType> getOrganizationType(Object data);
//统计条数
	int selectCounts(Map<String, Object> count);
}