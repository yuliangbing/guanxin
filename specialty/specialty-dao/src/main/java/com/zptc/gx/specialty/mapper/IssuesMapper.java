package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Issues;

public interface IssuesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Issues record);

    int insertSelective(Issues record);

    Issues selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Issues record);

    int updateByPrimaryKey(Issues issues);
    
    //获取全部列表数据
 	List<Issues> getIssuesList(Object data);
 	
 	//统计数据条数
 	int selectCounts(Map<String,Object> counts);
 	
 	int updateByPrimaryKeyDel(Issues issues);
 	
}