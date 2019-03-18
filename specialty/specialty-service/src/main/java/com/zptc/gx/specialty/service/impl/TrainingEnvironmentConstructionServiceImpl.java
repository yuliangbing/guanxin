package com.zptc.gx.specialty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;
import com.zptc.gx.specialty.mapper.TrainingEnvironmentConstructionMapper;
import com.zptc.gx.specialty.service.TrainingEnvironmentConstructionService;

@Component
public class TrainingEnvironmentConstructionServiceImpl implements TrainingEnvironmentConstructionService {

	@Autowired
	private TrainingEnvironmentConstructionMapper trainingEnvironmentConstructionMapper;

	@Override
	public void addTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction){
		trainingEnvironmentConstructionMapper.insertSelective(trainingEnvironmentConstruction);
	}
	@Override
	public void modifyTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction){
		trainingEnvironmentConstructionMapper.updateByPrimaryKeySelective(trainingEnvironmentConstruction);
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
}
