package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.PatentType;

public interface PatentTypeService {

	public int addPatentType(PatentType patentType);

	public int modifyPatentType(PatentType patentType);

	public int deletePatentTypeById(Long id);

	public PatentType findPatentTypeById(Long id);

}
