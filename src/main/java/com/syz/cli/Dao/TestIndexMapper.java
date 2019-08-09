package com.syz.cli.Dao;

import com.syz.cli.entity.TestIndex;

public interface TestIndexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestIndex record);

    int insertSelective(TestIndex record);
}