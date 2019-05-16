package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.entity.PatentType;

public interface PatentTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PatentType record);

    int insertSelective(PatentType record);

    PatentType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PatentType record);

    int updateByPrimaryKey(PatentType record);
//下拉方法
	List<Patent> setectPatentTpyeList(Map<String, Object> data);
//获取列表
	List<Patent> getPatentTypeList(Object da);
//统计
	int selectCounts(Map<String, Object> count);
//软删除
	int updateByPrimaryKeyDel(PatentType patentType);
	
	
}