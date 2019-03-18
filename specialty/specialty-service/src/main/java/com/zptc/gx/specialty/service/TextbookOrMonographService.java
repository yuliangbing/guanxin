package com.zptc.gx.specialty.service;

import com.zptc.gx.specialty.entity.TextbookOrMonograph;

public interface TextbookOrMonographService {

	public void addTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph);

	public void modifyTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph);

	public void deleteTextbookOrMonographById(Long id);

	public TextbookOrMonograph findTextbookOrMonographById(Long id);

}
