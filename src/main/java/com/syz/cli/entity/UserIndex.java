package com.syz.cli.entity;



import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "user_index")
public class UserIndex implements Serializable {

    private static final long serialVersionUID = -7983220047430628318L;

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



}