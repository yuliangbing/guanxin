package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.TeacherTeam;

public interface TeacherTeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeacherTeam record);

    int insertSelective(TeacherTeam record);

    TeacherTeam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeacherTeam record);

    int updateByPrimaryKey(TeacherTeam record);
}