package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.mapper.ThesisMapper;
import com.zptc.gx.specialty.service.ThesisService;

@Component
public class ThesisServiceImpl implements ThesisService {

	@Autowired
	private ThesisMapper thesisMapper;

	@Override
	public int addThesis(Thesis thesis){
		return thesisMapper.insertSelective(thesis);
	}
	@Override
	public int modifyThesis(Thesis thesis){
		return  thesisMapper.updateByPrimaryKeySelective(thesis);
	}
	@Override
	public int deleteThesisById(Long id){
		return thesisMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Thesis findThesisById(Long id){
		Thesis thesis = thesisMapper.selectByPrimaryKey(id);
		return thesis;
	}
	@Override
	public List<Thesis> getThesisList(Object data) {
		// TODO Auto-generated method stub
		return thesisMapper.getThesisList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return thesisMapper.selectCounts(count);
	}
//	@Override
//	@Transactional
//	public int modifSpecialtyFilesDel(Issues issues) {
//		// TODO Auto-generated method stub
//		return issuesMapper.updateByPrimaryKeyDel(issues);
//	}
	@Override
	@Transactional
	public int modifThesisDel(Thesis thesis) {
		// TODO Auto-generated method stub
		return thesisMapper.updateByPrimaryKeyDel(thesis);
	}
}
