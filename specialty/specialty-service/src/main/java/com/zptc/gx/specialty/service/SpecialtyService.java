package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.Specialty;

public interface SpecialtyService {

	public void addSpecialty(Specialty specialty);

	public void modifySpecialty(Specialty specialty);

	public void deleteSpecialtyById(Long id);

	public Specialty findSpecialtyById(Long id);

}
