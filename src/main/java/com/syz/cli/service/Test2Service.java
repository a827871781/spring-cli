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
public class Test2Service {

    @Autowired
    private Test1Dao test1Dao;

    public void test(){
        System.out.println("这个是被Controller调用方法");
        this.test1();
    }

    public void test1(){
        System.out.println("这个是Service调用方法");
    }


}
