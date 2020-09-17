package com.my.goodprovide.Controller;

import com.my.goodprovide.Service.UserService;
import com.my.goodprovide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public int login_check(HttpSession session, @RequestBody User getuser) {
        System.out.println("请求拦截用户名：" + getuser.getName());
        System.out.println("请求拦截密码：" + getuser.getPassword());
        User user = userService.login_check(getuser.getName());
        System.out.println("视图中心从数据中心获取的账号：" + user);
        int result = 0;
        //验证密码是否相等
        if (user.getPassword().equals(getuser.getPassword())){
            session.setAttribute("user", user);
            System.out.println("Session已保存的用户信息：" + session.getAttribute("user"));
            //List <role> RoleList = userService.getRole(name);
            //System.out.println("获取角色：" + RoleList);
            //session.setAttribute("role", RoleList);
            //List <perm> PermList = userService.GetPerm(name);
            //System.out.println("获取权限：" + PermList);
            //session.setAttribute("perm", PermList);
            result = 1;
            return result;
        }
        else{
            result = 2;
            return result;
        }
        }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        session.removeAttribute("user");
        return "success";
    }
}