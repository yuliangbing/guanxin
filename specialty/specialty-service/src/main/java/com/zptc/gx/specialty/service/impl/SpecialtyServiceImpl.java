package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.mapper.SpecialtyMapper;
import com.zptc.gx.specialty.mapper.SpecialtyProfileMapper;
import com.zptc.gx.specialty.service.SpecialtyService;

@Component
public class SpecialtyServiceImpl implements SpecialtyService {

	@Autowired
	private SpecialtyMapper specialtyMapper;
	@Autowired
	private SpecialtyProfileMapper specialtyProfileMapper;
	//添加专业
	@Override
	@Transactional
	public int addSpecialty(Specialty specialty){
		int count = 0;
		System.out.println("specialty=="+specialty);
		count += specialtyMapper.insertSelective(specialty);
		SpecialtyProfile specialtyProfile = new SpecialtyProfile();
		specialtyProfile.setSpecialtyId(specialty.getId());
		specialtyProfile.setSpecialtyName(specialty.getName());
		specialtyProfile.setPosition("");
		specialtyProfile.setCharacteristic("");
		specialtyProfile.setStatus(1);
		count += specialtyProfileMapper.insertSelective(specialtyProfile);
		if (count > 0) {
			System.out.println("添加专业概况成功");
		}
		return count;
	}
	//修改专业
	//带if的修改
	@Override
	public int modifySpecialty(Specialty specialty){
		return specialtyMapper.updateByPrimaryKeySelective(specialty);
	}
	//不带if的修改
	@Override
	public int modifySpecialtyKey(Specialty specialty){
		return specialtyMapper.updateByPrimaryKey(specialty);
	}
	//删除专业
	@Override
	public int deleteSpecialtyById(Long id){
		return specialtyMapper.deleteByPrimaryKey(id);
	}
	//根据id查询专业数据
	@Override
	public Specialty findSpecialtyById(Long id){
		Specialty specialty = specialtyMapper.selectByPrimaryKey(id);
		return specialty;
	}
	@Override
	public List<Specialty> findSpecialtyByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return specialtyMapper.findSpecialtyByRoleId(roleId);
	}
	//获取专业全部数据（下拉方法）
	@Override
	public List<Specialty> getSpecialtyList(Object data) {
		// TODO Auto-generated method stub
		return specialtyMapper.getSpecialtyList(data);
	}
	//统计数据条数
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return specialtyMapper.selectCounts(count);
	}
	//根据status修改状态（删除，@Transactional是回滚）
	@Override
	@Transactional
	public int modifSpecialtyDel(Specialty specialty) {
		// TODO Auto-generated method stub
		return specialtyMapper.updateByPrimaryKeyDel(specialty);
	}
	//获取专业信息全部数据
	@Override
	public List<Specialty> ListSpecialty(Object data) {
		// TODO Auto-generated method stub
		return specialtyMapper.SpecialtyLists(data);
	}
	//获取在这个时间之前包括该时间段中的专业数量
	@Override
	public int datesCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return specialtyMapper.dateCounts(count);
	}
	@Override
	public List<Specialty> getEnableSpecialtyList() {
		// TODO Auto-generated method stub
		return specialtyMapper.getEnableSpecialtyList();
	}
}
