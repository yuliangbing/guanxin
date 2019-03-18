package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.ForeignExchange;
import com.zptc.gx.specialty.mapper.ForeignExchangeMapper;
import com.zptc.gx.specialty.service.ForeignExchangeService;

@Component
public class ForeignExchangeServiceImpl implements ForeignExchangeService {

	@Autowired
	private ForeignExchangeMapper foreignExchangeMapper;

	@Override
	public void addForeignExchange(ForeignExchange foreignExchange){
		foreignExchangeMapper.insertSelective(foreignExchange);
	}
	@Override
	public void modifyForeignExchange(ForeignExchange foreignExchange){
		foreignExchangeMapper.updateByPrimaryKeySelective(foreignExchange);
	}
	@Override
	public void deleteForeignExchangeById(Long id){
		foreignExchangeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public ForeignExchange findForeignExchangeById(Long id){
		ForeignExchange foreignExchange = foreignExchangeMapper.selectByPrimaryKey(id);
		return foreignExchange;
	}
}
