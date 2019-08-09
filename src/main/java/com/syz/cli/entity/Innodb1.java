package com.syz.cli.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author syz
 */
@Data
@TableName(value = "innodb1")
@Accessors(chain = true)
public class Innodb1 extends Model<Innodb1> {

    private static final long serialVersionUID = -7369636839866883092L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "first_name")
    private String firstName;
    @TableField(value = "last_name")
    private String lastName;

    @TableField(value = "id_card")
    private String idCard;

    @TableField(value = "information")
    private String information;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    public Innodb1 createInnodb(){
        this.setIdCard("A");
        this.setCreateTime(new Date());
        this.setLastName("B");
        this.setUpdateTime(new Date());
        this.setFirstName("C");
        return  this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}