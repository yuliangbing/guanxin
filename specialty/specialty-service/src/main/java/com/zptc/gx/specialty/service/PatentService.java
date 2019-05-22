package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface PatentService {

	public int addPatent(Patent patent);

	public int modifyPatent(Patent patent);

	public int deletePatentById(Long id);

	public Patent findPatentById(Long id);

	public List<Patent> getPatentList(Map<String, Object> data);

	public int selectCounts(Map<String, Object> count);

	//根据status修改状态（删除）
	public int modifyPatentDel(Patent patent);
	//获得某专利类型数量数据统计的方法
	public int patentCounts(Map<String, Object> count);
}
