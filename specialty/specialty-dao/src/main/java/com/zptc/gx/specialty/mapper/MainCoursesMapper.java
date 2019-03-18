package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.MainCourses;

public interface MainCoursesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MainCourses record);

    int insertSelective(MainCourses record);

    MainCourses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MainCourses record);

    int updateByPrimaryKey(MainCourses record);
}