package com.syz.cli.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.syz.cli.entity.TestIndex;
import com.syz.cli.Dao.TestIndexMapper;
@Service
public class TestIndexService{

    @Resource
    private TestIndexMapper testIndexMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return testIndexMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(TestIndex record) {
        return testIndexMapper.insert(record);
    }

    
    public int insertSelective(TestIndex record) {
        return testIndexMapper.insertSelective(record);
    }

}
