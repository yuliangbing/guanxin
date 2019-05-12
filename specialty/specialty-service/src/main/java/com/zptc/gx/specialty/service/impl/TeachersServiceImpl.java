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
	public int addTeachers(Teachers teachers){
		return teachersMapper.insertSelective(teachers);
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
	/*@Override
	public int  delTeachersStaus(Teachers teachers) {
		// TODO Auto-generated method stub
		return teachersMapper.delByPrimaryKeyStaus(teachers);
	}*/
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return teachersMapper.selectCounts(count);
	}
	//查询name是否存在
	@Override
	public Teachers findTeachersByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Teachers teachers = teachersMapper.selectByName(map);
		return teachers;
	}
	//用于获取specialtyId相同的教师数据
	@Override
	public List<String> getTeachersByIdList(Map<String, Object> Tdata) {
		// TODO Auto-generated method stub
		return teachersMapper.getTeacherByList(Tdata);
	}
	@Override
	public int delTeachers(Teachers teachers) {
		// TODO Auto-generated method stub
		return teachersMapper.updateByStatus(teachers);
	}
}
