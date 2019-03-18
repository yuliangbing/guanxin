package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.Teachers;

public interface TeachersService {

	public void addTeachers(Teachers teachers);

	public void modifyTeachers(Teachers teachers);

	public void deleteTeachersById(Long id);

	public Teachers findTeachersById(Long id);

}
