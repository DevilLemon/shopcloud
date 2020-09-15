package com.example.provide.Service;

import com.example.provide.Client.Feign;
import com.example.provide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    Feign feign;
    //公共部分
    //登录验证
    public User login_check(@RequestParam("name") String name){
        System.out.println("服务获取从数据中心返回的：" + feign.login_check(name));
        return feign.login_check(name);
    };
    //User部分

    //Admin部分

}
