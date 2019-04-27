package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface ThesisService {

	public 
	int addThesis(Thesis thesis);

	public int modifyThesis(Thesis thesis);

	public int deleteThesisById(Long id);

	public Thesis findThesisById(Long id);
	
	//获取课程的全部数据
	public List<Thesis> getThesisList(Object data);

	//统计数据条数
	public int selectCounts(Map<String, Object> count);
		
	//根据status修改状态（删除）
	public int modifThesisDel(Thesis thesis);

}
