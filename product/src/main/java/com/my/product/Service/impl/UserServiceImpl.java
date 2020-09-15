package com.my.product.Service.impl;

import com.my.product.Mapper.UserMapper;
import com.my.product.MyObject.User;
import com.my.product.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login_check(String name) {
        return userMapper.login_check(name);
    }
}
