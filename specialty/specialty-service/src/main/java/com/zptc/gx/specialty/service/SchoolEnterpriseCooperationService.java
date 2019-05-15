package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;

public interface SchoolEnterpriseCooperationService {

	public int addSchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation);

	public int modifySchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation);

	public void deleteSchoolEnterpriseCooperationById(Long id);

	public SchoolEnterpriseCooperation findSchoolEnterpriseCooperationById(Long id);
//软删除，改变stauts
	public int modifySchoolEnterpriseCooperationDel(SchoolEnterpriseCooperation schoolEnterpriseCooperation);
//获取列表信息
	public List<SchoolEnterpriseCooperation> getSchoolEnterpriseCooperationList(Map<String, Object> data);
//数据条统计
	public int selectCounts(Map<String, Object> count);

}
