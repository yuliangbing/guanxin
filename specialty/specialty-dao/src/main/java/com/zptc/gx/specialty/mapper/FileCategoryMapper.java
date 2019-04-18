package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.FileCategory;

public interface FileCategoryMapper {
	//删除id=？这条数据
    int deleteByPrimaryKey(Long id);
    //不带if的插入
    int insert(FileCategory record);
    //带if的插入
    int insertSelective(FileCategory record);
    //查询id=?的数据
    FileCategory selectByPrimaryKey(Long id);
    //带if的修改
    int updateByPrimaryKeySelective(FileCategory record);
    //不带if的修改
    int updateByPrimaryKey(FileCategory record);
    //获取全部列表数据
    List<FileCategory> getFileCategoryList(Object data);
  //统计数据条数
  	int selectCounts(Map<String,Object> counts);
  	//根据status修改状态（删除）
  	int updateByPrimaryKeyDel(FileCategory fileCategory);
}