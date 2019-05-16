package com.zptc.gx.specialty.service;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TextbookOrMonograph;

public interface TextbookOrMonographService {

	public int addTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph);

	public int modifyTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph);

	public void deleteTextbookOrMonographById(Long id);

	public TextbookOrMonograph findTextbookOrMonographById(Long id);
	//获取列表
	public List<TextbookOrMonograph> getTextbookOrMonographList(Map<String, Object> data);
	//统计
	public int selectCounts(Map<String, Object> count);
	//软删除
	public int delTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph);

}
