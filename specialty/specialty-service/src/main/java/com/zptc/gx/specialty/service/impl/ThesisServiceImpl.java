package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.mapper.ThesisMapper;
import com.zptc.gx.specialty.service.ThesisService;

@Component
public class ThesisServiceImpl implements ThesisService {

	@Autowired
	private ThesisMapper thesisMapper;

	@Override
	public void addThesis(Thesis thesis){
		thesisMapper.insertSelective(thesis);
	}
	@Override
	public void modifyThesis(Thesis thesis){
		thesisMapper.updateByPrimaryKeySelective(thesis);
	}
	@Override
	public void deleteThesisById(Long id){
		thesisMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Thesis findThesisById(Long id){
		Thesis thesis = thesisMapper.selectByPrimaryKey(id);
		return thesis;
	}
}
