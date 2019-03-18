package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.Thesis;

public interface ThesisService {

	public void addThesis(Thesis thesis);

	public void modifyThesis(Thesis thesis);

	public void deleteThesisById(Long id);

	public Thesis findThesisById(Long id);

}
