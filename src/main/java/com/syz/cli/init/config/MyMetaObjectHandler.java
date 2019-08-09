package com.syz.cli.init.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 自定义填充公共 name 字段
 */
//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    /**
     * 测试 user 表 name 字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 更多查看源码测试用例
        System.out.println("insert fill");
        // 测试下划线
        Object testType = getFieldValByName("testType", metaObject);
        System.out.println("testType=" + testType);
        if (testType == null) {
            setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
            setFieldValByName("createTime", new Timestamp(System.currentTimeMillis()), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新填充
        System.out.println("update fill");
        //mybatis-plus版本2.0.9+
        setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
    }
}