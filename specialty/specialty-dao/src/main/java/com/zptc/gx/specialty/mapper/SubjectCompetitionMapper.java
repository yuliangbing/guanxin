package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.SubjectCompetition;

public interface SubjectCompetitionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubjectCompetition record);

    int insertSelective(SubjectCompetition record);

    SubjectCompetition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubjectCompetition record);

    int updateByPrimaryKey(SubjectCompetition record);
}