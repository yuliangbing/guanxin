package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Teachers;

public interface TeachersService {

	public void addTeachers(Teachers teachers);

	public int modifyTeachers(Teachers teachers);

	public void deleteTeachersById(Long id);

	public Teachers findTeachersById(Long id);

	public List<Teachers> getTeachersList(Map<String, Object> data);
	
	public int delTeachersStaus(Teachers teachers);

	public int selectCounts(Map<String, Object> count);

//	public <TeachersController> TeachersController findTeacherTeamById(Long id);

	public int modifySpecialtyProfile(TeachersService teachersService);

	public Teachers findTeacherTeambySpecialtyId(Long specialty_id);

}
