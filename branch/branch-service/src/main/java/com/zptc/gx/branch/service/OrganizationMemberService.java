package com.zptc.gx.branch.service;

import com.zptc.gx.branch.entity.OrganizationMember;

public interface OrganizationMemberService {

	public int addOrganizationMember(OrganizationMember organizationMember);

	public int modifyOrganizationMember(OrganizationMember organizationMember);

	public int deleteOrganizationMemberById(Long id);

	public OrganizationMember findOrganizationMemberById(Long id);

}
