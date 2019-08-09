package com.syz.cli.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;import java.io.Serializable;

@Data
@TableName(value = "user")
public class User extends Model<User> {
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}