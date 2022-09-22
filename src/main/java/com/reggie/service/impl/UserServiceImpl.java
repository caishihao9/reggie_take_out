package com.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reggie.entity.User;
import com.reggie.mapper.UserMapper;
import com.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author caishihao
 * @version 2021.1
 * @date 2022/9/17 15:13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}