package com.zptc.gx.specialty.mapper;

import java.util.List;
import java.util.Map;

import com.zptc.gx.specialty.entity.TextbookOrMonograph;

public interface TextbookOrMonographMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TextbookOrMonograph record);

    int insertSelective(TextbookOrMonograph record);

    TextbookOrMonograph selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TextbookOrMonograph record);

    int updateByPrimaryKey(TextbookOrMonograph record);
    //列表
	List<TextbookOrMonograph> textbookOrMonographList(Map<String, Object> data);
	//统计
	int Counts(Map<String, Object> count);
	//软删除
	int updateByPrimaryKeyDel(TextbookOrMonograph textbookOrMonograph);
}