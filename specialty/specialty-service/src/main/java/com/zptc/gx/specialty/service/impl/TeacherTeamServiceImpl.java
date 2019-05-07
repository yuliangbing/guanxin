package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.mapper.TeacherTeamMapper;
import com.zptc.gx.specialty.service.TeacherTeamService;

@Component
public class TeacherTeamServiceImpl implements TeacherTeamService {

	@Autowired
	private TeacherTeamMapper teacherTeamMapper;

	@Override
	public void addTeacherTeam(TeacherTeam teacherTeam){
		teacherTeamMapper.insertSelective(teacherTeam);
	}
	@Override
	public void modifyTeacherTeam(TeacherTeam teacherTeam){
		teacherTeamMapper.updateByPrimaryKeySelective(teacherTeam);
	}
	@Override
	public void deleteTeacherTeamById(Long id){
		teacherTeamMapper.deleteByPrimaryKey(id);
	}
	@Override
	public TeacherTeam findTeacherTeamById(Long id){
		TeacherTeam teacherTeam = teacherTeamMapper.selectByPrimaryKey(id);
		return teacherTeam;
	}
	@Override
	public int selectCounts(Map<String, Object> counts) {
		// TODO Auto-generated method stub
		return teacherTeamMapper.selectCounts(counts);
	}
	@Override
	public List<TeacherTeam> getTeacherTeamList(Object data) {
		// TODO Auto-generated method stub
		return teacherTeamMapper.getTeacherTeamList(data);
	}
	@Override
	public int modifySpecialtyProfile(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		return 0;
	}
}
