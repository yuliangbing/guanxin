package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int modifyTeachers(Teachers teachers){
		return teachersMapper.updateByPrimaryKeySelective(teachers);
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
	@Override
	public List<Teachers> getTeachersList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return teachersMapper.getTeachersList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int modifySpecialtyProfile(TeachersService teachersService) {
		// TODO Auto-generated method stub
		return 0;
	}
@Override
public int  delTeachersStaus(Teachers teachers) {
	// TODO Auto-generated method stub
	return teachersMapper.delByPrimaryKeyStaus(teachers);
}
@Override
public  Teachers findTeacherTeambySpecialtyId(Long specialty_id) {
	// TODO Auto-generated method stub
	return null;
}
}
