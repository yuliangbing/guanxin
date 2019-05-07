package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.TeacherTeam;

public interface TeacherTeamService {

	public void addTeacherTeam(TeacherTeam teacherTeam);

	public void modifyTeacherTeam(TeacherTeam teacherTeam);

	public void deleteTeacherTeamById(Long id);

	public TeacherTeam findTeacherTeamById(Long id);

	public int selectCounts(Map<String, Object> count);
	
	public List<TeacherTeam> getTeacherTeamList(Object data);

	public int modifySpecialtyProfile(TeacherTeam teacherTeam);

	

}
