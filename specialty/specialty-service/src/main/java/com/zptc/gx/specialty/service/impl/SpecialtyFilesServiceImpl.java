package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.mapper.SpecialtyFilesMapper;
import com.zptc.gx.specialty.service.SpecialtyFilesService;

@Component
public class SpecialtyFilesServiceImpl implements SpecialtyFilesService {

	@Autowired
	private SpecialtyFilesMapper specialtyFilesMapper;

	@Override
	public void addSpecialtyFiles(SpecialtyFiles specialtyFiles){
		specialtyFilesMapper.insertSelective(specialtyFiles);
	}
	@Override
	public void modifySpecialtyFiles(SpecialtyFiles specialtyFiles){
		specialtyFilesMapper.updateByPrimaryKeySelective(specialtyFiles);
	}
	@Override
	public void deleteSpecialtyFilesById(Long id){
		specialtyFilesMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyFiles findSpecialtyFilesById(Long id){
		SpecialtyFiles specialtyFiles = specialtyFilesMapper.selectByPrimaryKey(id);
		return specialtyFiles;
	}
}
