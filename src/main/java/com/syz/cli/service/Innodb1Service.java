package com.syz.cli.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.syz.cli.Dao.Innodb1Mapper;
import com.syz.cli.entity.Innodb1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class Innodb1Service extends ServiceImpl<Innodb1Mapper, Innodb1> {


	@Autowired
	private Innodb1Mapper innodb1Mapper;

	public List<Innodb1> getInnodb() {
		Innodb1 innodb1 = new Innodb1();

		return innodb1Mapper.selectByAll(innodb1);


	}

    public void insertBatch1(List<Innodb1> list) {
		innodb1Mapper.insertList(list);
    }

    public Map<String ,Object> test3() {
		return 	innodb1Mapper.selectMap();
    }
}
