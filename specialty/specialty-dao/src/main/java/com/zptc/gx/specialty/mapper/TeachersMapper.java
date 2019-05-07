package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.entity.Teachers;

public interface TeachersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
    //改变状态码
    int delByPrimaryKeyStaus(Teachers record);
    
    int selectCounts(Map<String, Object> counts);
    
     List<Teachers> getTeachersList(Object data);
}