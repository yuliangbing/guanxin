package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.FileCategory;
import com.zptc.gx.specialty.mapper.FileCategoryMapper;
import com.zptc.gx.specialty.service.FileCategoryService;

@Component
public class FileCategoryServiceImpl implements FileCategoryService {

	@Autowired
	private FileCategoryMapper fileCategoryMapper;

	@Override
	public void addFileCategory(FileCategory fileCategory){
		fileCategoryMapper.insertSelective(fileCategory);
	}
	@Override
	public void modifyFileCategory(FileCategory fileCategory){
		fileCategoryMapper.updateByPrimaryKeySelective(fileCategory);
	}
	@Override
	public void deleteFileCategoryById(Long id){
		fileCategoryMapper.deleteByPrimaryKey(id);
	}
	@Override
	public FileCategory findFileCategoryById(Long id){
		FileCategory fileCategory = fileCategoryMapper.selectByPrimaryKey(id);
		return fileCategory;
	}
}
