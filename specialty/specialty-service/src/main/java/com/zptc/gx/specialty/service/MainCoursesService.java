package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.MainCourses;

public interface MainCoursesService {

	public int addMainCourses(MainCourses mainCourses);

	public int modifyMainCourses(MainCourses mainCourses);

	public void deleteMainCoursesById(Long id);

	public MainCourses findMainCoursesById(Long id);
	//列表
	public List<MainCourses> getMainCoursesList(Map<String, Object> data);
	//统计
	public int selectCounts(Map<String, Object> count);
	//软删除
	public int delMainCourses(MainCourses mainCourses);

}
