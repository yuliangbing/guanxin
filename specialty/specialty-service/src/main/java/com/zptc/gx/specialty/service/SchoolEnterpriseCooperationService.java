package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;

public interface SchoolEnterpriseCooperationService {

	public void addSchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation);

	public void modifySchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation);

	public void deleteSchoolEnterpriseCooperationById(Long id);

	public SchoolEnterpriseCooperation findSchoolEnterpriseCooperationById(Long id);

}
