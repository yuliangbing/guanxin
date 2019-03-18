package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.FileCategory;

public interface FileCategoryService {

	public void addFileCategory(FileCategory fileCategory);

	public void modifyFileCategory(FileCategory fileCategory);

	public void deleteFileCategoryById(Long id);

	public FileCategory findFileCategoryById(Long id);

}
