package com.zptc.gx.mapper;

import com.zptc.gx.entity.SubjectCompetition;

public interface SubjectCompetitionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubjectCompetition record);

    int insertSelective(SubjectCompetition record);

    SubjectCompetition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubjectCompetition record);

    int updateByPrimaryKey(SubjectCompetition record);
}