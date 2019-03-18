package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.SubjectCompetition;

public interface SubjectCompetitionService {

	public void addSubjectCompetition(SubjectCompetition subjectCompetition);

	public void modifySubjectCompetition(SubjectCompetition subjectCompetition);

	public void deleteSubjectCompetitionById(Long id);

	public SubjectCompetition findSubjectCompetitionById(Long id);

}
