package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.entity.SpecialtyProfile;

public interface SpecialtyProfileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyProfile record);

    int insertSelective(SpecialtyProfile record);

    SpecialtyProfile selectByPrimaryKey(Long id);
    
  //获取全部列表数据
  	List<SpecialtyProfile> getSpecialtyProfileList(Object data);

    int updateByPrimaryKeySelective(SpecialtyProfile record);
//  软删除
    int updateByPrimaryKeyDel(SpecialtyProfile record);

	int selectCounts(Map<String, Object> count);
	// 获取相同专业id，且status==1的数据
	List<SpecialtyProfile> selectByIdAndStatus(Map<String, Object> map);
	
	int updateBySpecialtyId(Long specialtyId);
	
}