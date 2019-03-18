package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyFilesService {

	public void addSpecialtyFiles(SpecialtyFiles specialtyFiles);

	public void modifySpecialtyFiles(SpecialtyFiles specialtyFiles);

	public void deleteSpecialtyFilesById(Long id);

	public SpecialtyFiles findSpecialtyFilesById(Long id);

}
