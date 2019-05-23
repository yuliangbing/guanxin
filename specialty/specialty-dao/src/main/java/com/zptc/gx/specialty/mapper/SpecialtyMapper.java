package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.Specialty;

public interface SpecialtyMapper {
	//删除id=？这条数据
    int deleteByPrimaryKey(Long id);
    //不带if的插入
    int insert(Specialty record);
    //带if的插入
    int insertSelective(Specialty record);
    //查询id=?的数据
    Specialty selectByPrimaryKey(Long id);
    //带if的修改
    int updateByPrimaryKeySelective(Specialty record);
    //不带if的修改
    int updateByPrimaryKey(Specialty record);

	List<Specialty> findSpecialtyByRoleId(Long roleId);
	//获取全部列表数据（下拉方法）
	List<Specialty> getSpecialtyList(Object data);
	//获取全部数据
	List<Specialty> SpecialtyLists (Object data);
	//统计数据条数
	int selectCounts(Map<String,Object> counts);
	//根据status修改状态（删除）
	int updateByPrimaryKeyDel(Specialty specialty);
	//获取在这个时间之前包括该时间段中的专业数量
	int dateCounts(Map<String, Object> count);
	
	List<Specialty> getEnableSpecialtyList();
}