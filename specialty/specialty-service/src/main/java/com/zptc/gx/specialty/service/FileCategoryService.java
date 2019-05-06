package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.FileCategory;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface FileCategoryService {
	//添加文件类型
	public int addFileCategory(FileCategory fileCategory);
	//修改文件类型
	//带if条件
	public int modifyFileCategory(FileCategory fileCategory);
	//删除文件类型
	public int deleteFileCategoryById(Long id);
	//根据id查询文件类型
	public FileCategory findFileCategoryById(Long id);
	//获取全部数据（下拉方法）
	public List<FileCategory> getFileCategoryList(Object data);
	//统计数据条数
	public int selectCounts(Map<String, Object> count);
	//根据status修改状态（删除）
	public int modifFileCategoryDel(FileCategory fileCategory);
	//获取专业文件全部数据
	public List<FileCategory> FileCategoryList(Map<String, Object> data);
}
