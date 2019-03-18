package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.MainCourses;
import com.zptc.gx.specialty.mapper.MainCoursesMapper;
import com.zptc.gx.specialty.service.MainCoursesService;

@Component
public class MainCoursesServiceImpl implements MainCoursesService {

	@Autowired
	private MainCoursesMapper mainCoursesMapper;

	@Override
	public void addMainCourses(MainCourses mainCourses){
		mainCoursesMapper.insertSelective(mainCourses);
	}
	@Override
	public void modifyMainCourses(MainCourses mainCourses){
		mainCoursesMapper.updateByPrimaryKeySelective(mainCourses);
	}
	@Override
	public void deleteMainCoursesById(Long id){
		mainCoursesMapper.deleteByPrimaryKey(id);
	}
	@Override
	public MainCourses findMainCoursesById(Long id){
		MainCourses mainCourses = mainCoursesMapper.selectByPrimaryKey(id);
		return mainCourses;
	}
}
