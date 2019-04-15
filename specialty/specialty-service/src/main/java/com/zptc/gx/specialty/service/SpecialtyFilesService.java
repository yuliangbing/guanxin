package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyFilesService {
	//添加专业文件
	public int addSpecialtyFiles(SpecialtyFiles specialtyFiles);
	//修改专业文件
	//带if条件
	public int modifySpecialtyFiles(SpecialtyFiles specialtyFiles);
	//不带if条件
	public int modifySpecialtyFilesKey(SpecialtyFiles specialtyFiles);
	//删除专业文件
	public int deleteSpecialtyFilesById(Long id);
	//根据id查询专业文件数据
	public SpecialtyFiles findSpecialtyFilesById(Long id);
	//获取专业文件全部数据
	public List<SpecialtyFiles> getSpecialtyFilesList(Object data);
	
	public List<Map<String, Object>> getSpecialtyFilesListMap(Object object);
	//统计数据条数
	public int selectCounts(Map<String, Object> count);
	
	//根据status修改状态（删除）
	public int modifSpecialtyFilesDel(SpecialtyFiles specialtyFiles);
}
