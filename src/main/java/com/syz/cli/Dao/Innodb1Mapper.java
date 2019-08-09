package com.syz.cli.Dao;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.syz.cli.entity.Innodb1;
import org.apache.ibatis.annotations.SelectProvider;

public interface Innodb1Mapper extends BaseMapper<Innodb1> {


    List<Innodb1> selectByAll(Innodb1 innodb1);

    int insertList(@Param("list")List<Innodb1> list);


    Map<String,Object> selectMap();
}