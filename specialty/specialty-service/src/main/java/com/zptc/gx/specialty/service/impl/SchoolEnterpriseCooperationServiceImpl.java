package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;
import com.zptc.gx.specialty.mapper.SchoolEnterpriseCooperationMapper;
import com.zptc.gx.specialty.service.SchoolEnterpriseCooperationService;

@Component
public class SchoolEnterpriseCooperationServiceImpl implements SchoolEnterpriseCooperationService {

	@Autowired
	private SchoolEnterpriseCooperationMapper schoolEnterpriseCooperationMapper;

	@Override
	public int addSchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation){
		return schoolEnterpriseCooperationMapper.insertSelective(schoolEnterpriseCooperation);
	}
	@Override
	public int modifySchoolEnterpriseCooperation(SchoolEnterpriseCooperation schoolEnterpriseCooperation){
		return schoolEnterpriseCooperationMapper.updateByPrimaryKeySelective(schoolEnterpriseCooperation);
	}
	@Override
	public void deleteSchoolEnterpriseCooperationById(Long id){
		schoolEnterpriseCooperationMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SchoolEnterpriseCooperation findSchoolEnterpriseCooperationById(Long id){
		SchoolEnterpriseCooperation schoolEnterpriseCooperation = schoolEnterpriseCooperationMapper.selectByPrimaryKey(id);
		return schoolEnterpriseCooperation;
	}
//	软删除处理
	@Override
	@Transactional//事务回滚
	public int modifySchoolEnterpriseCooperationDel(SchoolEnterpriseCooperation schoolEnterpriseCooperation) {
		// TODO Auto-generated method stub
		return schoolEnterpriseCooperationMapper.modifySchoolEnterpriseCooperationDel(schoolEnterpriseCooperation);
	}
//	获取列表信息
	@Override
	public List<SchoolEnterpriseCooperation> getSchoolEnterpriseCooperationList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return schoolEnterpriseCooperationMapper.getSchoolEnterpriseCooperationList(data);
	}
//	统计数据条数
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return schoolEnterpriseCooperationMapper.selectCounts(count);
	}
}
