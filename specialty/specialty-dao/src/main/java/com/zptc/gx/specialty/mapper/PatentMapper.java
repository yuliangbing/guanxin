package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;

public interface PatentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record);

	List<Patent> getPatentList(Map<String, Object> data);

	int selectCounts(Map<String, Object> count);
	
	//根据status修改状态（删除）
	int updateByPrimaryKeyDel(Patent patent);
	//获得某专利类型数量数据统计的方法
	int PCounts(Map<String, Object> count);
}