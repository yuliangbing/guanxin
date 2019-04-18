package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.FileCategory;
import com.zptc.gx.specialty.mapper.FileCategoryMapper;
import com.zptc.gx.specialty.service.FileCategoryService;

@Component
public class FileCategoryServiceImpl implements FileCategoryService {

	@Autowired
	private FileCategoryMapper fileCategoryMapper;
	//添加文件类型
	@Override
	public void addFileCategory(FileCategory fileCategory){
		fileCategoryMapper.insertSelective(fileCategory);
	}
	//修改文件类型
	//带if条件
	@Override
	public void modifyFileCategory(FileCategory fileCategory){
		fileCategoryMapper.updateByPrimaryKeySelective(fileCategory);
	}
	//删除文件类型
	@Override
	public void deleteFileCategoryById(Long id){
		fileCategoryMapper.deleteByPrimaryKey(id);
	}
	//根据id查询文件类型
	@Override
	public FileCategory findFileCategoryById(Long id){
		FileCategory fileCategory = fileCategoryMapper.selectByPrimaryKey(id);
		return fileCategory;
	}
	//获取专业文件全部数据
	@Override
	public List<FileCategory> getFileCategoryList(Object data) {
		// TODO Auto-generated method stub
		return fileCategoryMapper.getFileCategoryList(data);
	}
	//统计数据条数
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return fileCategoryMapper.selectCounts(count);
	}
	//根据status修改状态（删除，@Transactional是回滚）
	@Override
	@Transactional
	public int modifFileCategoryDel(FileCategory fileCategory) {
		// TODO Auto-generated method stub
		return fileCategoryMapper.updateByPrimaryKeyDel(fileCategory);
	}
}
