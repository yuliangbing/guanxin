package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.Patent;

public interface PatentService {

	public void addPatent(Patent patent);

	public void modifyPatent(Patent patent);

	public void deletePatentById(Long id);

	public Patent findPatentById(Long id);

}
