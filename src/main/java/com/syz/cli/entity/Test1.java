package com.syz.cli.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@TableName("test1")
@Builder
public class Test1 extends Model<Test1> {
    private static final long serialVersionUID = 1L;

    private String id;
    private String value;
    //@TableField(strategy = FieldStrategy.IGNORED)
    private String key;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
