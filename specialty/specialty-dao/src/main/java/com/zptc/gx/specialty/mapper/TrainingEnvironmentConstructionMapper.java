package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;

public interface TrainingEnvironmentConstructionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrainingEnvironmentConstruction record);

    int insertSelective(TrainingEnvironmentConstruction record);

    TrainingEnvironmentConstruction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrainingEnvironmentConstruction record);

    int updateByPrimaryKey(TrainingEnvironmentConstruction record);
//软删除，改变status
	int modifyTrainingEnvironmentConstructionDel(TrainingEnvironmentConstruction trainingEnvironmentConstruction);
//获取列表数据
	List<TrainingEnvironmentConstruction> getTrainingEnvironmentConstructionList(Map<String, Object> data);
//统计数据条数
	int selectCounts(Map<String, Object> count);
}