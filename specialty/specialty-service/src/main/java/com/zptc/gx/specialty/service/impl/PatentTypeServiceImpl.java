package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.entity.PatentType;
import com.zptc.gx.specialty.mapper.PatentTypeMapper;
import com.zptc.gx.specialty.service.PatentTypeService;

@Component
public class PatentTypeServiceImpl implements PatentTypeService {

	@Autowired
	private PatentTypeMapper patentTypeMapper;

	@Override
	public int addPatentType(PatentType patentType){
		return patentTypeMapper.insertSelective(patentType);
	}
	@Override
	public int modifyPatentType(PatentType patentType){
		return patentTypeMapper.updateByPrimaryKeySelective(patentType);
	}
	@Override
	public int deletePatentTypeById(Long id){
		return patentTypeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public PatentType findPatentTypeById(Long id){
		PatentType patentType = patentTypeMapper.selectByPrimaryKey(id);
		return patentType;
	}
	//下拉方法
	@Override
	public List<Patent> selectPatentType(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return patentTypeMapper.setectPatentTpyeList(data);
	}
	//获取列表
	@Override
	public List<Patent> getPatentTypeList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return patentTypeMapper.getPatentTypeList(data);
	}
	//统计
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return patentTypeMapper.selectCounts(count);
	}
	//软删除
	@Override
	public int delPatenType(PatentType patentType) {
		// TODO Auto-generated method stub
		return patentTypeMapper.updateByPrimaryKeyDel(patentType);
	}
}
