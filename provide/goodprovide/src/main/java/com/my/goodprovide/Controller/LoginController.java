package com.my.goodprovide.Controller;

import com.my.goodprovide.Service.UserService;
import com.my.goodprovide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String login_check(HttpSession session,String name, String password) {
        //查询数据库登录用户信息
        User user = userService.login_check(name);
        System.out.println("视图中心从数据中心获取的账号：" + user);
        //验证密码是否相等
        if (user.getPassword().equals(password)){
            session.setAttribute("user", user);
            System.out.println("Session已保存的用户信息：" + session.getAttribute("user"));
            //List <role> RoleList = userService.getRole(name);
            //System.out.println("获取角色：" + RoleList);
            //session.setAttribute("role", RoleList);
            //List <perm> PermList = userService.GetPerm(name);
            //System.out.println("获取权限：" + PermList);
            //session.setAttribute("perm", PermList);
            return "success";
        }
        else{
            return "false";
        }
        }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        session.removeAttribute("user");
        return "success";
    }
}