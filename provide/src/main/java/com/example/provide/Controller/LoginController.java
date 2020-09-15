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

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ModelAndView login_check(HttpSession session,String name, String password) {
        //查询数据库登录用户信息
        User user = userService.login_check(name);
        System.out.println("视图中心从数据中心获取的账号：" + user);
        //验证密码是否相等
        if (user.getPassword().equals(password)){
            session.setAttribute("user", user);
            User test = (User)session.getAttribute("user");
            System.out.println("缓存获取：" + test);
            System.out.println("名字输出：" + test.getName());
            System.out.println("密码输出：" + test.getPassword());
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