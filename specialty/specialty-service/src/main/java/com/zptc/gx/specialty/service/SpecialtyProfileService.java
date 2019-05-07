package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.entity.SpecialtyProfile;

public interface SpecialtyProfileService {

	public int addSpecialtyProfile(SpecialtyProfile specialtyProfile);

	public int modifySpecialtyProfile(SpecialtyProfile specialtyProfile);

	public void deleteSpecialtyProfileById(Long id);

	public SpecialtyProfile findSpecialtyProfileById(Long id);
	
	public List<SpecialtyProfile> getSpecialtyProfileList(Object data);
	
	public int selectCounts(Map<String, Object> count);

	public int modifSpecialtyFilesDel(SpecialtyProfile specialtyFiles);

}
