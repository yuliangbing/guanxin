package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.MainCourses;

public interface MainCoursesService {

	public void addMainCourses(MainCourses mainCourses);

	public void modifyMainCourses(MainCourses mainCourses);

	public void deleteMainCoursesById(Long id);

	public MainCourses findMainCoursesById(Long id);

}
