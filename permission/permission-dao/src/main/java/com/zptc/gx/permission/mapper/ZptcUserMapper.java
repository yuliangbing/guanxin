package com.zptc.gx.permission.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.permission.entity.ZptcUser;

public interface ZptcUserMapper {
	ZptcUser selectByPrimaryKey(Long id);
	
    int deleteByPrimaryKey(Long id);

    int insert(ZptcUser record);

    int insertSelective(ZptcUser record);

    int updateByPrimaryKeySelective(ZptcUser record);

    int updateByPrimaryKey(ZptcUser record);
    
    List<ZptcUser> findByParam(Map<String, Object> par);
//获取列表数据
	List<ZptcUser> getZptcUserList(Map<String, Object> data);
//统计数据条数
	int selectCounts(Map<String, Object> count);
//软删除，改变stauts
	int deleteByStauts(ZptcUser zptcUser);
}