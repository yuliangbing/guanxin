package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyConstructionAchievementsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionAchievements record);

    int insertSelective(SpecialtyConstructionAchievements record);

    SpecialtyConstructionAchievements selectByPrimaryKey(Long id);
    //带if
    int updateByPrimaryKeySelective(SpecialtyConstructionAchievements record);
    //不带if
    int updateByPrimaryKey(SpecialtyConstructionAchievements record);
    
    //查询专业全部数据
	List<SpecialtyConstructionAchievements> getSpecialtyList(Map<String, Object> data);
	
	//统计数据条数
	int selectCounts(Map<String,Object> counts);
	
	//根据status修改状态（删除）
	int updateByPrimaryKeyDel(SpecialtyConstructionAchievements Id);
}