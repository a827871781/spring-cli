package com.syz.cli.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.syz.cli.Dao.UserMapper;
import com.syz.cli.entity.User;
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
