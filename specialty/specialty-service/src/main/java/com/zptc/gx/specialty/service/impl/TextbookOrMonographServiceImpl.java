package com.zptc.gx.specialty.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zptc.gx.specialty.entity.TextbookOrMonograph;
import com.zptc.gx.specialty.mapper.TextbookOrMonographMapper;
import com.zptc.gx.specialty.service.TextbookOrMonographService;

@Component
public class TextbookOrMonographServiceImpl implements TextbookOrMonographService {

	@Autowired
	private TextbookOrMonographMapper textbookOrMonographMapper;

	@Override
	public int addTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph){
		return textbookOrMonographMapper.insertSelective(textbookOrMonograph);
	}
	@Override
	public int modifyTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph){
		return textbookOrMonographMapper.updateByPrimaryKeySelective(textbookOrMonograph);
	}
	@Override
	public void deleteTextbookOrMonographById(Long id){
		textbookOrMonographMapper.deleteByPrimaryKey(id);
	}
	@Override
	public TextbookOrMonograph findTextbookOrMonographById(Long id){
		TextbookOrMonograph textbookOrMonograph = textbookOrMonographMapper.selectByPrimaryKey(id);
		return textbookOrMonograph;
	}
	//列表
	@Override
	public List<TextbookOrMonograph> getTextbookOrMonographList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return textbookOrMonographMapper.textbookOrMonographList(data);
	}
	//统计
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return textbookOrMonographMapper.Counts(count);
	}
	//软删除
	@Override
	public int delTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph) {
		// TODO Auto-generated method stub
		return textbookOrMonographMapper.updateByPrimaryKeyDel(textbookOrMonograph);
	}
}
