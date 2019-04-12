package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.mapper.SpecialtyFilesMapper;
import com.zptc.gx.specialty.service.SpecialtyFilesService;

@Component
public class SpecialtyFilesServiceImpl implements SpecialtyFilesService {

	@Autowired
	private SpecialtyFilesMapper specialtyFilesMapper;
	//新增专业文件
	@Override
	public int addSpecialtyFiles(SpecialtyFiles specialtyFiles){
		return specialtyFilesMapper.insertSelective(specialtyFiles);
	}
	//修改专业文件
	//带if
	@Override
	public int modifySpecialtyFiles(SpecialtyFiles specialtyFiles){
		return  specialtyFilesMapper.updateByPrimaryKeySelective(specialtyFiles);
	}
	//删除专业文件
	@Override
	public int deleteSpecialtyFilesById(Long id){
		return  specialtyFilesMapper.deleteByPrimaryKey(id);
	}
	//查询专业文件数据
	@Override
	public SpecialtyFiles findSpecialtyFilesById(Long id){
		SpecialtyFiles specialtyFiles = specialtyFilesMapper.selectByPrimaryKey(id);
		return specialtyFiles;
	}
	//不带if查询专业文件
	@Override
	public int modifySpecialtyFilesKey(SpecialtyFiles specialtyFiles) {
		// TODO Auto-generated method stub
		return specialtyFilesMapper.updateByPrimaryKey(specialtyFiles);
	}
	//获取专业文件列表数据
	@Override
	public List<SpecialtyFiles> getSpecialtyFilesList(Object object) {
		// TODO Auto-generated method stub
		return specialtyFilesMapper.getSpecialtyFilesList(object);
	}
	@Override
	public List<Map<String, Object>> getSpecialtyFilesListMap(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
