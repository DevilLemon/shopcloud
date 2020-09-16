package com.my.goodprovide.Controller;

import com.my.goodprovide.Service.UserService;
import com.my.goodprovide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping("/register_check")
    public String register(User user) throws Exception{
        System.out.println("注册的用户：" + user);
        userService.register(user);
        return "success";
    }
}