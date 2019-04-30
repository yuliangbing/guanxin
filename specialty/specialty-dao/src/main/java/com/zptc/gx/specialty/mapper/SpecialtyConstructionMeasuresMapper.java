package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.entity.SpecialtyFiles;

public interface SpecialtyConstructionMeasuresMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialtyConstructionMeasures record);

    int insertSelective(SpecialtyConstructionMeasures record);

    SpecialtyConstructionMeasures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialtyConstructionMeasures record);

    int updateByPrimaryKey(SpecialtyConstructionMeasures record);

	List<SpecialtyConstructionMeasures> getMeasuresList(Object data);

	int selectCounts(Map<String, Object> count);

	//根据status修改状态（删除）
	int updateByPrimaryKeyDel(SpecialtyConstructionMeasures specialtyConstructionMeasures);
}