package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.entity.Teachers;

public interface TeachersService {

	public int addTeachers(Teachers teachers);

	public int modifyTeachers(Teachers teas);

	public void deleteTeachersById(Long id);

	public Teachers findTeachersById(Long id);

	public List<Teachers> getTeachersList(Map<String, Object> data);
	
	//public int delTeachersStaus(Teachers teachers);

	public int selectCounts(Map<String, Object> count);

	public Teachers findTeachersByName(Map<String, Object> map);
	//用于获取specialtyId相同的教师数据
	public List<String> getTeachersByIdList(Map<String, Object> tdata);

	public int delTeachers(Teachers teachers);

}
