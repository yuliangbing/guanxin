package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;

public interface SchoolEnterpriseCooperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolEnterpriseCooperation record);

    int insertSelective(SchoolEnterpriseCooperation record);

    SchoolEnterpriseCooperation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolEnterpriseCooperation record);

    int updateByPrimaryKey(SchoolEnterpriseCooperation record);
//软删除处理
	int modifySchoolEnterpriseCooperationDel(SchoolEnterpriseCooperation schoolEnterpriseCooperation);
//获取列表信息
	List<SchoolEnterpriseCooperation> getSchoolEnterpriseCooperationList(Map<String, Object> data);
//数据条统计
	int selectCounts(Map<String, Object> count);
}