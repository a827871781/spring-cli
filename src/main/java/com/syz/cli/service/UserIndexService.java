package com.syz.cli.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.syz.cli.Dao.UserIndexMapper;
import com.syz.cli.entity.UserIndex;
@Service
public class UserIndexService extends ServiceImpl<UserIndexMapper, UserIndex> {

}
