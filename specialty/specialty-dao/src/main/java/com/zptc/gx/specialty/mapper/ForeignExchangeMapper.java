package com.zptc.gx.specialty.mapper;

import com.zptc.gx.specialty.entity.ForeignExchange;

public interface ForeignExchangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ForeignExchange record);

    int insertSelective(ForeignExchange record);

    ForeignExchange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ForeignExchange record);

    int updateByPrimaryKey(ForeignExchange record);
}