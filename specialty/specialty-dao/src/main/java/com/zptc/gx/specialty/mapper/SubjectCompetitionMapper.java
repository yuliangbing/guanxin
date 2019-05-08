package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SubjectCompetition;

public interface SubjectCompetitionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubjectCompetition record);

    int insertSelective(SubjectCompetition record);

    SubjectCompetition selectByPrimaryKey(String award_level);
    
    SubjectCompetition selectByPrimaryKeyId(Long id);

    int updateByPrimaryKeySelective(SubjectCompetition record);

    int updateByPrimaryKey(SubjectCompetition record);
  //获取全部列表数据
	List<SubjectCompetition> getSubjectCompetitionList(Map<String, Object> data);

	int selectCounts(Map<String, Object> count);
}