package com.my.product.Controller;

import com.my.product.MyObject.User;
import com.my.product.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public User login_check(String name){
        System.out.println("数据中心的查询依据" + name);
        User user = userService.login_check(name);
        System.out.println("数据中心查询的用户信息" + user);
        return user;
    }
}