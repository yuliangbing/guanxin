package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.TeacherTeam;

public interface TeacherTeamService {

	public int addTeacherTeam(TeacherTeam teacherTeam);

	public int modifyTeacherTeam(TeacherTeam teacherTeam);

	public int deleteTeacherTeamById(Long id);

	public TeacherTeam findTeacherTeamById(Long id);
	
	//获取id和latest最新数据
	public TeacherTeam findTeacherTeamByIdAndLatest(Map<String, Object> data);

	public int selectCounts(Map<String, Object> count);
	
	public List<TeacherTeam> getTeacherTeamList(Object data);

	public List<TeacherTeam> getTeacherTeamList(Map<String, Object> data);

	public int Counts(Map<String, Object> count);

	

}
