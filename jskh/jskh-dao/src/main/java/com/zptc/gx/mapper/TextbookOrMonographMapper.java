package com.zptc.gx.mapper;

import com.zptc.gx.entity.TextbookOrMonograph;

public interface TextbookOrMonographMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TextbookOrMonograph record);

    int insertSelective(TextbookOrMonograph record);

    TextbookOrMonograph selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TextbookOrMonograph record);

    int updateByPrimaryKey(TextbookOrMonograph record);
}