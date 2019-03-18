package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SpecialtyProfile;

public interface SpecialtyProfileService {

	public void addSpecialtyProfile(SpecialtyProfile specialtyProfile);

	public void modifySpecialtyProfile(SpecialtyProfile specialtyProfile);

	public void deleteSpecialtyProfileById(Long id);

	public SpecialtyProfile findSpecialtyProfileById(Long id);

}
