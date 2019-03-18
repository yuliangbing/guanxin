package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface SpecialtyConstructionMeasuresService {

	public void addSpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures);

	public void modifySpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures);

	public void deleteSpecialtyConstructionMeasuresById(Long id);

	public SpecialtyConstructionMeasures findSpecialtyConstructionMeasuresById(Long id);

}
