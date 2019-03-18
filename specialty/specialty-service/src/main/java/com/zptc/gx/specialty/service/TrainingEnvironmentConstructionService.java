package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;

public interface TrainingEnvironmentConstructionService {

	public void addTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction);

	public void modifyTrainingEnvironmentConstruction(TrainingEnvironmentConstruction trainingEnvironmentConstruction);

	public void deleteTrainingEnvironmentConstructionById(Long id);

	public TrainingEnvironmentConstruction findTrainingEnvironmentConstructionById(Long id);

}
