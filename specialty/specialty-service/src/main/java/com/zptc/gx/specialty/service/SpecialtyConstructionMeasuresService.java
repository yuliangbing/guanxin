package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface SpecialtyConstructionMeasuresService {
	//添加
	public int addSpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures);
	//修改
	//带if
	public int modifySpecialtyConstructionMeasures(SpecialtyConstructionMeasures specialtyConstructionMeasures);
	//不带if
	public int modifySpecialtyConstructionAchievementsKey(SpecialtyConstructionMeasures specialtyConstructionMeasures);
	//删除
	public int deleteSpecialtyConstructionMeasuresById(Long id);
	//根据id查询数据
	public SpecialtyConstructionMeasures findSpecialtyConstructionMeasuresById(Long id);
	//获取列表数据
	public List<SpecialtyConstructionMeasures> getSpecialtyMeasuresList(Object data);
	//统计
	public int selectCounts(Map<String, Object> count);
	//根据status修改状态（删除）
	public int modifSpecialtyMeasuresDel(SpecialtyConstructionMeasures specialtyConstructionMeasures);
}
