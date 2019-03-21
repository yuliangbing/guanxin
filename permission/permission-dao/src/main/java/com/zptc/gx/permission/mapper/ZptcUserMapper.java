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
}