package com.syz.cli.service;

import com.syz.cli.Dao.Test1Dao;
import com.syz.cli.entity.Test1;
import com.syz.cli.entity.Test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author syz
 * @version 1.0
 * @create 2019-05-17 14:20
 **/
@Service
public class Test1Service  {



    @Autowired
    private Test1Dao test1Dao ;


    @Transactional(rollbackFor = Exception.class)
    public void insertOne(){
        Test1 test1 = new Test1();
        test1.setId(UUID.randomUUID().toString());
        test1.setKey("k");
        test1.setValue("v");
        test1.insert();

    }
    public List<Test1> inset(){
        List<Test1> test1s = test1Dao.selectAll();
        return test1s;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertTwo(){
        Test2 test = new Test2();
        test.setId(UUID.randomUUID().toString());
        test.setValue("v");
        test.insert();
    }

    public String  test() {
        return "Test1Service";
    }



}
