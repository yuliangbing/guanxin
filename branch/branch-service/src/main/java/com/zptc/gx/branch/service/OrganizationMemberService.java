package com.zptc.gx.branch.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.branch.entity.OrganizationMember;

public interface OrganizationMemberService {

	public int addOrganizationMember(OrganizationMember organizationMember);

	public int modifyOrganizationMember(OrganizationMember organizationMember);

	public int deleteOrganizationMemberById(Long id);

	public OrganizationMember findOrganizationMemberById(Long id);
//获取列表方法
	public List<OrganizationMember> getOrganizationMemberList(Map<String, Object> data);
//	软删除，改变status
	public int delOrganizationMemberById(OrganizationMember organizationMember);
//	统计数据条数
	public int selectCounts(Map<String, Object> count);

}
