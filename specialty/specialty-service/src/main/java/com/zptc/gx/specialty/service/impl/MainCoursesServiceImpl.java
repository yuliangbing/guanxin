package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addMainCourses(MainCourses mainCourses){
		return mainCoursesMapper.insertSelective(mainCourses);
	}
	@Override
	public int modifyMainCourses(MainCourses mainCourses){
		return mainCoursesMapper.updateByPrimaryKeySelective(mainCourses);
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
	//列表
	@Override
	public List<MainCourses> getMainCoursesList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return mainCoursesMapper.MainCoursesList(data);
	}
	//统计
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return mainCoursesMapper.Counts(count);
	}
	//软删除
	@Override
	public int delMainCourses(MainCourses mainCourses) {
		// TODO Auto-generated method stub
		return mainCoursesMapper.updateByPrimaryKeyDel(mainCourses);
	}
}
