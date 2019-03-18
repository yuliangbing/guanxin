package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.TeacherTeam;

public interface TeacherTeamService {

	public void addTeacherTeam(TeacherTeam teacherTeam);

	public void modifyTeacherTeam(TeacherTeam teacherTeam);

	public void deleteTeacherTeamById(Long id);

	public TeacherTeam findTeacherTeamById(Long id);

}
