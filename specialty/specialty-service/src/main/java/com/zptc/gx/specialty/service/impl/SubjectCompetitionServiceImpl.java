package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.SubjectCompetition;
import com.zptc.gx.specialty.mapper.SubjectCompetitionMapper;
import com.zptc.gx.specialty.service.SubjectCompetitionService;

@Component
public class SubjectCompetitionServiceImpl implements SubjectCompetitionService {

	@Autowired
	private SubjectCompetitionMapper subjectCompetitionMapper;

	@Override
	public int addSubjectCompetition(SubjectCompetition subjectCompetition){
		return subjectCompetitionMapper.insertSelective(subjectCompetition);
	}
	@Override
	@Transactional//事务回滚
	public int modifySubjectCompetition(SubjectCompetition subjectCompetition){
		return subjectCompetitionMapper.updateByPrimaryKeySelective(subjectCompetition);
	}
	@Override
	public void deleteSubjectCompetitionById(Long id){
		subjectCompetitionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SubjectCompetition findSubjectCompetitionByawardLevel(String award_level){
		SubjectCompetition subjectCompetition = subjectCompetitionMapper.selectByPrimaryKey(award_level);
		return subjectCompetition;
	}
	@Override
	public SubjectCompetition findSubjectCompetitionById(Long id) {
		// TODO Auto-generated method stub
		SubjectCompetition subjectCompetition = subjectCompetitionMapper.selectByPrimaryKeyId(id);
		return subjectCompetition;
	}
	@Override
	public List<SubjectCompetition> getSubjectCompetitionList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return subjectCompetitionMapper.getSubjectCompetitionList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return subjectCompetitionMapper.selectCounts(count);
	}
}
