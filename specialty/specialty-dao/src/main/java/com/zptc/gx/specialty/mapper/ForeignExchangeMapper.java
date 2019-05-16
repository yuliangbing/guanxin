package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.ForeignExchange;

public interface ForeignExchangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ForeignExchange record);

    int insertSelective(ForeignExchange record);

    ForeignExchange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ForeignExchange record);

    int updateByPrimaryKey(ForeignExchange record);
    //获取列表
	List<ForeignExchange> ForeignExchangeList(Map<String, Object> data);
	//统计
	int Counts(Map<String, Object> count);
	//软删除
	int updateByPrimaryKeyDel(ForeignExchange foreignExchange);
}