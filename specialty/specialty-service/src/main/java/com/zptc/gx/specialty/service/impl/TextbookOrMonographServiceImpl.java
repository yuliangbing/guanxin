package com.zptc.gx.specialty.service.impl;

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
	public void addTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph){
		textbookOrMonographMapper.insertSelective(textbookOrMonograph);
	}
	@Override
	public void modifyTextbookOrMonograph(TextbookOrMonograph textbookOrMonograph){
		textbookOrMonographMapper.updateByPrimaryKeySelective(textbookOrMonograph);
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
}
