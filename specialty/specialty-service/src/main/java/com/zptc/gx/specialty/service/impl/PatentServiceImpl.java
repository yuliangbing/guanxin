package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.mapper.PatentMapper;
import com.zptc.gx.specialty.service.PatentService;

@Component
public class PatentServiceImpl implements PatentService {

	@Autowired
	private PatentMapper patentMapper;

	@Override
	public void addPatent(Patent patent){
		patentMapper.insertSelective(patent);
	}
	@Override
	public void modifyPatent(Patent patent){
		patentMapper.updateByPrimaryKeySelective(patent);
	}
	@Override
	public void deletePatentById(Long id){
		patentMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Patent findPatentById(Long id){
		Patent patent = patentMapper.selectByPrimaryKey(id);
		return patent;
	}
}
