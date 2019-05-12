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
	public int addTeacherTeam(TeacherTeam teacherTeam){
		return teacherTeamMapper.insertSelective(teacherTeam);
	}
	@Override
	public int modifyTeacherTeam(TeacherTeam teacherTeam){
		return teacherTeamMapper.updateByPrimaryKeySelective(teacherTeam);
	}
	@Override
	public int deleteTeacherTeamById(Long id){
		return teacherTeamMapper.deleteByPrimaryKey(id);
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
	}/*
	@Override
	public int modifySpecialtyProfile(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	@Override
	public TeacherTeam findTeacherTeamByIdAndLatest(Map<String, Object> data) {
		// TODO Auto-generated method stub
		TeacherTeam teacherTeam = teacherTeamMapper.selectByIdAndLatest(data);
		return teacherTeam;
	}
	@Override
	public int modifySpecialtyProfile(TeacherTeam teacherTeam) {
		// TODO Auto-generated method stub
		return 0;
	}
}
