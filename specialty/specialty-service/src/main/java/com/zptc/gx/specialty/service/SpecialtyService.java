package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Specialty;

public interface SpecialtyService {
	//添加专业
	public int addSpecialty(Specialty specialty);
	//修改专业
	//带if条件
	public int modifySpecialty(Specialty specialty);
	//不带if条件
	public int modifySpecialtyKey(Specialty specialty);
	//删除专业
	public int deleteSpecialtyById(Long id);
	//根据id查询专业数据
	public Specialty findSpecialtyById(Long id);
	
	public List<Specialty> findSpecialtyByRoleId(Long roleId);
	
	//专业信息全部数据（用于下拉方法）
	public List<Specialty> getSpecialtyList(Object data);
	
	//专业信息全部数据
	public List<Specialty> ListSpecialty(Object data);
	
	//统计数据条数
	public int selectCounts(Map<String, Object> count);
	
	//根据status修改状态（删除）
	public int modifSpecialtyDel(Specialty specialty);
	//获取在这个时间之前包括该时间段中的专业数量
	public int datesCounts(Map<String, Object> count);
	
	//获取没有装也概况的专业列表
	public List<Specialty> getEnableSpecialtyList();
}
