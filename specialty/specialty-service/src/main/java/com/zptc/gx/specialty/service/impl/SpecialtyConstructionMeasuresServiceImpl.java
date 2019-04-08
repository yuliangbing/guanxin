package com.zptc.gx.specialty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.mapper.SpecialtyConstructionMeasuresMapper;
import com.zptc.gx.specialty.service.SpecialtyConstructionMeasuresService;

@Component
public class SpecialtyConstructionMeasuresServiceImpl implements SpecialtyConstructionMeasuresService {

	@Autowired
	private SpecialtyConstructionMeasuresMapper specialtyConstructionMeasuresMapper;
	//新增
	@Override
	public int addSpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures){
		return specialtyConstructionMeasuresMapper.insertSelective(specialtyConstructionMeasures);
	}
	//带if修改
	@Override
	public int modifySpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures){
		return  specialtyConstructionMeasuresMapper.updateByPrimaryKeySelective(specialtyConstructionMeasures);
	}
	//根据id删除数据
	@Override
	public int deleteSpecialtyConstructionMeasuresById(Long id){
		return  specialtyConstructionMeasuresMapper.deleteByPrimaryKey(id);
	}
	//根据id来查询
	@Override
	public SpecialtyConstructionMeasures findSpecialtyConstructionMeasuresById(Long id){
		SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresMapper.selectByPrimaryKey(id);
		return specialtyConstructionMeasures;
	}
	//获取列表数据
	@Override
	public int modifySpecialtyConstructionAchievementsKey(SpecialtyConstructionMeasures specialtyConstructionMeasures) {
		// TODO Auto-generated method stub
		return specialtyConstructionMeasuresMapper.updateByPrimaryKey(specialtyConstructionMeasures);
	}
	//不带if修改
	@Override
	public List<SpecialtyConstructionMeasures> getSpecialtyIdList(Long specialtyId) {
		// TODO Auto-generated method stub
		return specialtyConstructionMeasuresMapper.getSpecialtyIdList(specialtyId);
	}
}
