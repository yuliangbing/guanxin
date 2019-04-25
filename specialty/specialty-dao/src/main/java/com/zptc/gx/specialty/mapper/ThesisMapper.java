package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Thesis;

public interface ThesisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    Thesis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
    
  //获取全部列表数据
   	List<Thesis> getThesisList(Object data);
   	
   	//统计数据条数
   	int selectCounts(Map<String,Object> counts);
   	
   	int updateByPrimaryKeyDel(Thesis thesis);
}