package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.TeacherTeam;

public interface TeacherTeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeacherTeam record);

    int insertSelective(TeacherTeam record);

    TeacherTeam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeacherTeam record);

    int updateByPrimaryKey(TeacherTeam record);
    
    int selectCounts(Map<String, Object> counts);
    
    List<TeacherTeam> getTeacherTeamList(Object data);

	TeacherTeam selectByIdAndLatest(Map<String, Object> data);
}