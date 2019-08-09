package com.syz.cli.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author syz
 * @version 1.0
 * @create 2019-05-17 14:09
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("test2")
public class Test2 extends Model<Test2> {
    private static final long serialVersionUID = 1L;

    private String id;
    private String value;
    private String key;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
