package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SubjectCompetition;

public interface SubjectCompetitionService {

	public int addSubjectCompetition(SubjectCompetition subjectCompetition);

	public int modifySubjectCompetition(SubjectCompetition subjectCompetition);

	public void deleteSubjectCompetitionById(Long id);

	//public SubjectCompetition findSubjectCompetitionById(String award_level);

	public SubjectCompetition findSubjectCompetitionByawardLevel(String award_level);

	public SubjectCompetition findSubjectCompetitionById(Long id);

	public List<SubjectCompetition> getSubjectCompetitionList(Map<String, Object> data);

	public int selectCounts(Map<String, Object> count);

}
