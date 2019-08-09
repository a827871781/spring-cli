package com.syz.cli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.syz.cli.Dao")//mybatis 扫描包
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
