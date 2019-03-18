package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.mapper.SpecialtyConstructionMeasuresMapper;
import com.zptc.gx.specialty.service.SpecialtyConstructionMeasuresService;

@Component
public class SpecialtyConstructionMeasuresServiceImpl implements SpecialtyConstructionMeasuresService {

	@Autowired
	private SpecialtyConstructionMeasuresMapper specialtyConstructionMeasuresMapper;

	@Override
	public void addSpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures){
		specialtyConstructionMeasuresMapper.insertSelective(specialtyConstructionMeasures);
	}
	@Override
	public void modifySpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures){
		specialtyConstructionMeasuresMapper.updateByPrimaryKeySelective(specialtyConstructionMeasures);
	}
	@Override
	public void deleteSpecialtyConstructionMeasuresById(Long id){
		specialtyConstructionMeasuresMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyConstructionMeasures findSpecialtyConstructionMeasuresById(Long id){
		SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresMapper.selectByPrimaryKey(id);
		return specialtyConstructionMeasures;
	}
}
