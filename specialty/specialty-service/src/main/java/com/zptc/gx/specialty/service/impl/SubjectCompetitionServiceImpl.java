package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.SubjectCompetition;
import com.zptc.gx.specialty.mapper.SubjectCompetitionMapper;
import com.zptc.gx.specialty.service.SubjectCompetitionService;

@Component
public class SubjectCompetitionServiceImpl implements SubjectCompetitionService {

	@Autowired
	private SubjectCompetitionMapper subjectCompetitionMapper;

	@Override
	public void addSubjectCompetition(SubjectCompetition subjectCompetition){
		subjectCompetitionMapper.insertSelective(subjectCompetition);
	}
	@Override
	public void modifySubjectCompetition(SubjectCompetition subjectCompetition){
		subjectCompetitionMapper.updateByPrimaryKeySelective(subjectCompetition);
	}
	@Override
	public void deleteSubjectCompetitionById(Long id){
		subjectCompetitionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SubjectCompetition findSubjectCompetitionById(Long id){
		SubjectCompetition subjectCompetition = subjectCompetitionMapper.selectByPrimaryKey(id);
		return subjectCompetition;
	}
}
