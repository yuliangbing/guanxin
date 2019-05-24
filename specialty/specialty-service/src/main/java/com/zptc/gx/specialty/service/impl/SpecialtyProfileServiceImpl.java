package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.mapper.SpecialtyProfileMapper;
import com.zptc.gx.specialty.service.SpecialtyProfileService;

@Component
public class SpecialtyProfileServiceImpl implements SpecialtyProfileService {

	@Autowired
	private SpecialtyProfileMapper specialtyProfileMapper;

	@Override
	@Transactional
	public int addSpecialtyProfile(SpecialtyProfile specialtyProfile){
		int count = 0;
		count += specialtyProfileMapper.updateBySpecialtyId(specialtyProfile.getSpecialtyId());
		count += specialtyProfileMapper.insertSelective(specialtyProfile);
		return count;
	}
	@Override
	public int modifySpecialtyProfile(SpecialtyProfile specialtyProfile){
		return specialtyProfileMapper.updateByPrimaryKeySelective(specialtyProfile);
	}
	@Override
	public void deleteSpecialtyProfileById(Long id){
		specialtyProfileMapper.deleteByPrimaryKey(id);
	}
	@Override
	public SpecialtyProfile findSpecialtyProfileById(Long id){
		SpecialtyProfile specialtyProfile = specialtyProfileMapper.selectByPrimaryKey(id);
		return specialtyProfile;
	}
	@Override
	public List<SpecialtyProfile> getSpecialtyProfileList(Object data) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.getSpecialtyProfileList(data);
	}
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.selectCounts(count);
	}
//	软删除改变status
	@Override
	@Transactional//事务回滚
	public int modifSpecialtyFilesDel(SpecialtyProfile specialtyProfile) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.updateByPrimaryKeyDel(specialtyProfile);
	}
	// 获取相同专业id，且status==1的数据
	@Override
	public List<SpecialtyProfile> findSpecialtyProfileByIdAndStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return specialtyProfileMapper.selectByIdAndStatus(map);
	}
}
