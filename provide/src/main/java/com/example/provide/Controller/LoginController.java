package com.example.provide.Controller;

import com.example.provide.Service.UserService;
import com.example.provide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ModelAndView login_check(HttpSession session,String name, String password) {
        //查询数据库登录用户信息
        User user = userService.login_check(name);
        System.out.println("视图中心从数据中心获取的账号：" + user);
        //List <> RoleList = ;
        System.out.println("登录账号的角色：" + user);
        //List <> PermList = ;
        System.out.println("登录账号的权限：" + user);
        //验证密码是否相等
        if (user.getPassword().equals(password)){
            session.setAttribute("user", user);
            System.out.println("Session已保存的用户信息：" + session.getAttribute("user"));
            return new ModelAndView("index");
        }
        else{
        return new ModelAndView("login");
        }
        }
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        session.removeAttribute("user");
        return new ModelAndView("login");
    }
}