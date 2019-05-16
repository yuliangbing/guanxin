package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.MainCourses;

public interface MainCoursesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MainCourses record);

    int insertSelective(MainCourses record);

    MainCourses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MainCourses record);

    int updateByPrimaryKey(MainCourses record);
    //列表
	List<MainCourses> MainCoursesList(Map<String, Object> data);
	//统计
	int Counts(Map<String, Object> count);
	//软删除
	int updateByPrimaryKeyDel(MainCourses mainCourses);
}