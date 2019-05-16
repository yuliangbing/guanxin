package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.ForeignExchange;

public interface ForeignExchangeService {

	public int addForeignExchange(ForeignExchange foreignExchange);

	public int modifyForeignExchange(ForeignExchange foreignExchange);

	public void deleteForeignExchangeById(Long id);

	public ForeignExchange findForeignExchangeById(Long id);
	//获取列表
	public List<ForeignExchange> getForeignExchangeList(Map<String, Object> data);
	//统计
	public int selectCounts(Map<String, Object> count);
	//软删除
	public int delForeignExchange(ForeignExchange foreignExchange);

}
