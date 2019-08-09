package com.syz.cli.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author syz
 * @Version 1.0
 * @Create 2019-06-21 15:24
 **/
@Data
public class TestEntity {
    @NotBlank(message = "name空")
    private String  name ;
    @NotBlank(message = "test空")
    private String  test ;
}
