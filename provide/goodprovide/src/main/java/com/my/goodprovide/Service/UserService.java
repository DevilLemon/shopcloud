package com.my.goodprovide.Service;

import com.my.goodprovide.Client.Feign;
import com.my.goodprovide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    @Autowired
    Feign feign;
    //登录验证
    public User login_check(String name){
        System.out.println("服务拦截参数：" + name);
        System.out.println("服务获取从数据中心返回的：" + feign.login_check(name));
        return feign.login_check(name);
    };
    //注册公用
    public String register(User user){
        feign.register(user);
        return "success";
    };
    /*User findPassByName(String name); //查询USER_PASS
    Long getUserID(String name); //查询USER_ID公用
    //Admin专用
    List<User> adminUserList();
    void updateUser(User user);
    void resetPass(Long userid);
    void deleteUser(Long userid);
    UserInfo getUserInfo(Long userid);
    void updateUserInfo(UserInfo userInfo);*/
}
