package com.zptc.gx.specialty.service;

import java.util.List;

import com.zptc.gx.specialty.entity.Specialty;

public interface SpecialtyService {
	//添加专业
	public int addSpecialty(Specialty specialty);
	//修改专业
	public int modifySpecialty(Specialty specialty);
	//删除专业
	public int deleteSpecialtyById(Long id);
	//根据id查询专业数据
	public Specialty findSpecialtyById(Long id);
	
	public List<Specialty> findSpecialtyByRoleId(Long roleId);
	//根据specialtyId查询专业全部数据
	public List<Specialty> getSpecialtyIdList(Long specialtyId);
}
