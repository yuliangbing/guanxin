package com.zptc.gx.branch.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.OrganizationType;

public interface OrganizationTypeService {

	public int addOrganizationType(OrganizationType organizationType);

	public int modifyOrganizationType(OrganizationType organizationType);

//	public int deleteOrganizationTypeById(OrganizationType organizationType);
//	软删除，改变status
	public int delOrganizationTypeById(OrganizationType organizationType);

	public OrganizationType findOrganizationTypeById(Long id);

	public List<OrganizationType> getOrganizationTypeList(Map<String, Object> data);

}
