package com.syz.cli.Dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.syz.cli.entity.UserIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserIndexMapper extends BaseMapper<UserIndex> {


    List<UserIndex> queryById(String id);

    int deleteByLastName(@Param("lastName")String lastName);

    List<UserIndex> selectByFirstName(@Param("firstName")String firstName);

    int insertList(@Param("list")List<UserIndex> list);


    List<UserIndex> selectByFirstNameAndLastName(@Param("firstName")String firstName,@Param("lastName")String lastName);


    List<UserIndex> selectByAll(UserIndex userIndex);

    List<UserIndex> selectByAllA(UserIndex userIndex);

    int deleteByIdCard(@Param("idCard")String idCard);











}