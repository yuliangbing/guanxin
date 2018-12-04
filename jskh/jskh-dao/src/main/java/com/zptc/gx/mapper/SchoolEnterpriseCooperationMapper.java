package com.zptc.gx.mapper;

import com.zptc.gx.entity.SchoolEnterpriseCooperation;

public interface SchoolEnterpriseCooperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolEnterpriseCooperation record);

    int insertSelective(SchoolEnterpriseCooperation record);

    SchoolEnterpriseCooperation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolEnterpriseCooperation record);

    int updateByPrimaryKey(SchoolEnterpriseCooperation record);
}