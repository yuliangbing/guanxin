package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;

public interface TrainingEnvironmentConstructionService {

	public int addTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction);
//修改信息
	public int modifyTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction);

	public void deleteTrainingEnvironmentConstructionById(Long id);

	public TrainingEnvironmentConstruction findTrainingEnvironmentConstructionById(Long id);
//软删除，改变stauts
	public int modifyTrainingEnvironmentConstructionDel(TrainingEnvironmentConstruction trainingEnvironmentConstruction);
//	获取列表数据
	public List<TrainingEnvironmentConstruction> getTrainingEnvironmentConstructionList(Map<String, Object> data);
//统计数据条数
	public int selectCounts(Map<String, Object> count);

}
