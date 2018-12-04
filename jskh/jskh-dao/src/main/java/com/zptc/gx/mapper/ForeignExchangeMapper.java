package com.zptc.gx.mapper;

import com.zptc.gx.entity.ForeignExchange;

public interface ForeignExchangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ForeignExchange record);

    int insertSelective(ForeignExchange record);

    ForeignExchange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ForeignExchange record);

    int updateByPrimaryKey(ForeignExchange record);
}