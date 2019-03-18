package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.Teachers;
import com.zptc.gx.specialty.mapper.TeachersMapper;
import com.zptc.gx.specialty.service.TeachersService;

@Component
public class TeachersServiceImpl implements TeachersService {

	@Autowired
	private TeachersMapper teachersMapper;

	@Override
	public void addTeachers(Teachers teachers){
		teachersMapper.insertSelective(teachers);
	}
	@Override
	public void modifyTeachers(Teachers teachers){
		teachersMapper.updateByPrimaryKeySelective(teachers);
	}
	@Override
	public void deleteTeachersById(Long id){
		teachersMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Teachers findTeachersById(Long id){
		Teachers teachers = teachersMapper.selectByPrimaryKey(id);
		return teachers;
	}
}
