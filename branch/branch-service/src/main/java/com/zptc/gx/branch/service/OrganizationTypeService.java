package com.zptc.gx.branch.service;

import com.zptc.gx.branch.entity.OrganizationType;

public interface OrganizationTypeService {

	public int addOrganizationType(OrganizationType organizationType);

	public int modifyOrganizationType(OrganizationType organizationType);

	public int deleteOrganizationTypeById(Long id);

	public OrganizationType findOrganizationTypeById(Long id);

}
