package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.ForeignExchange;

public interface ForeignExchangeService {

	public void addForeignExchange(ForeignExchange foreignExchange);

	public void modifyForeignExchange(ForeignExchange foreignExchange);

	public void deleteForeignExchangeById(Long id);

	public ForeignExchange findForeignExchangeById(Long id);

}
