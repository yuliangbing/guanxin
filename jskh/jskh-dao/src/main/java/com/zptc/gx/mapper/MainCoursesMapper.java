package com.zptc.gx.mapper;

import com.zptc.gx.entity.MainCourses;

public interface MainCoursesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MainCourses record);

    int insertSelective(MainCourses record);

    MainCourses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MainCourses record);

    int updateByPrimaryKey(MainCourses record);
}