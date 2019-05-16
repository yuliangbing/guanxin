package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;
import com.zptc.gx.specialty.mapper.TrainingEnvironmentConstructionMapper;
import com.zptc.gx.specialty.service.TrainingEnvironmentConstructionService;

@Component
public class TrainingEnvironmentConstructionServiceImpl implements TrainingEnvironmentConstructionService {

	@Autowired
	private TrainingEnvironmentConstructionMapper trainingEnvironmentConstructionMapper;

	@Override
	public int addTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction){
		return trainingEnvironmentConstructionMapper.insertSelective(trainingEnvironmentConstruction);
	}
	@Override
	public int modifyTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction){
		return trainingEnvironmentConstructionMapper.updateByPrimaryKeySelective(trainingEnvironmentConstruction);
	}
	@Override
	public void deleteTrainingEnvironmentConstructionById(Long id){
		trainingEnvironmentConstructionMapper.deleteByPrimaryKey(id);
	}
	@Override
	public TrainingEnvironmentConstruction findTrainingEnvironmentConstructionById(Long id){
		TrainingEnvironmentConstruction trainingEnvironmentConstruction = trainingEnvironmentConstructionMapper.selectByPrimaryKey(id);
		return trainingEnvironmentConstruction;
	}
//	软删除处理
	@Override
	@Transactional//事务回滚
	public int modifyTrainingEnvironmentConstructionDel(
			TrainingEnvironmentConstruction trainingEnvironmentConstruction) {
		// TODO Auto-generated method stub
		return trainingEnvironmentConstructionMapper.modifyTrainingEnvironmentConstructionDel(trainingEnvironmentConstruction);
	}
//	获取列表信息
	@Override
	public List<TrainingEnvironmentConstruction> getTrainingEnvironmentConstructionList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return trainingEnvironmentConstructionMapper.getTrainingEnvironmentConstructionList(data);
	}
//	统计数据条数
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return trainingEnvironmentConstructionMapper.selectCounts(count);
	}
}
