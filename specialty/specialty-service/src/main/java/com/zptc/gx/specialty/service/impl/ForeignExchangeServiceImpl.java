package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

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
	public int addForeignExchange(ForeignExchange foreignExchange){
		return foreignExchangeMapper.insertSelective(foreignExchange);
	}
	@Override
	public int modifyForeignExchange(ForeignExchange foreignExchange){
		return foreignExchangeMapper.updateByPrimaryKeySelective(foreignExchange);
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
	//获取列表数据
	@Override
	public List<ForeignExchange> getForeignExchangeList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return foreignExchangeMapper.ForeignExchangeList(data);
	}
	//统计
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return foreignExchangeMapper.Counts(count);
	}
	//软删除
	@Override
	public int delForeignExchange(ForeignExchange foreignExchange) {
		// TODO Auto-generated method stub
		return foreignExchangeMapper.updateByPrimaryKeyDel(foreignExchange);
	}
}
