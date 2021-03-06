package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyFilesMapper {
	//删除id=？这条数据
    int deleteByPrimaryKey(Long id);
    //不带if的插入
    int insert(SpecialtyFiles record);
    //带if的插入
    int insertSelective(SpecialtyFiles record);
    //查询id=?的数据
    SpecialtyFiles selectByPrimaryKey(Long id);
    //带if的修改
    int updateByPrimaryKeySelective(SpecialtyFiles record);
    //不带if的修改
    int updateByPrimaryKey(SpecialtyFiles record);
    //获取全部列表数据
	List<SpecialtyFiles> getSpecialtyFilesList(Object data);
	//统计数据条数
	int selectCounts(Map<String,Object> counts);
	//根据status修改状态（删除）
	int updateByPrimaryKeyDel(SpecialtyFiles specialtyFilesId);
	//统计相同name的数据
	int nameCount(Map<String, Object> count);
	//统计相同专业的数据条数
	int specialtyCount(Map<String, Object> count);
}