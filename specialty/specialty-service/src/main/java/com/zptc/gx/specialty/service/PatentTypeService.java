package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.entity.PatentType;

public interface PatentTypeService {

	public int addPatentType(PatentType patentType);

	public int modifyPatentType(PatentType patentType);

	public int deletePatentTypeById(Long id);

	public PatentType findPatentTypeById(Long id);
	//下拉方法
	public List<Patent> selectPatentType(Map<String, Object> data);
	//获取列表
	public List<Patent> getPatentTypeList(Map<String, Object> data);
	//统计
	public int selectCounts(Map<String, Object> count);
	//删除(软删除)
	public int delPatenType(PatentType patentType);

}
