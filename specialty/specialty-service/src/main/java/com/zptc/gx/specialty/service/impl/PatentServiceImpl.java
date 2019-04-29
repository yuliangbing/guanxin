package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.mapper.PatentMapper;
import com.zptc.gx.specialty.service.PatentService;

@Component
public class PatentServiceImpl implements PatentService {

	@Autowired
	private PatentMapper patentMapper;

	@Override
	public int addPatent(Patent patent){
		return patentMapper.insertSelective(patent);
	}
	@Override
	public int modifyPatent(Patent patent){
		return patentMapper.updateByPrimaryKeySelective(patent);
	}
	@Override
	public int deletePatentById(Long id){
		return patentMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Patent findPatentById(Long id){
		Patent patent = patentMapper.selectByPrimaryKey(id);
		return patent;
	}
	@Override
	public List<Patent> getPatentList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return patentMapper.getPatentList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return patentMapper.selectCounts(count);
	}
	@Override
	@Transactional
	public int modifyPatentDel(Patent patent) {
		// TODO Auto-generated method stub
		return patentMapper.updateByPrimaryKeyDel(patent);
	}
}
