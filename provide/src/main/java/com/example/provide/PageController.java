package com.example.provide;

import com.example.provide.pobject.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class PageController {
    //公用部分
    @GetMapping("index")
    public ModelAndView index() { return new ModelAndView("index"); }
    @GetMapping("/register")
    public ModelAndView register() { return new ModelAndView("register"); }
    @GetMapping("/login")
    public ModelAndView login() { return new ModelAndView("login"); }
    @GetMapping("unauthorized")
    public ModelAndView noPerms() { return new ModelAndView("unauthorized"); }
    @GetMapping("errorPage")
    public ModelAndView errorPage() { return new ModelAndView("errorPage"); }
    @GetMapping("fileLoad")
    public ModelAndView fileLoad() { return new ModelAndView("fileLoad"); }
    //User专用部分
    @GetMapping("/userOwnerList")
    public ModelAndView userOwnerList() { return new ModelAndView("userOwnerList"); }
    @GetMapping("/userGoodList")
    public ModelAndView userGoodList() { return new ModelAndView("userGoodList"); }
    @GetMapping("/userGoodInfo")
    public ModelAndView userGoodInfo() { return new ModelAndView("userGoodInfo"); }
    @GetMapping("/userCartList")
    public ModelAndView userCartList() { return new ModelAndView("userCartList"); }
    @GetMapping("/userOrderList")
    public ModelAndView userOrderList() { return new ModelAndView("userOrderList"); }
    //Admin专用部分
    @GetMapping("/adminUserList")
    public ModelAndView adminUserList(HttpSession session) {
        User user = (User)session.getAttribute("user");
        System.out.println("页面跳转获取：" + user);
        return new ModelAndView("adminUserList");
    }
    @GetMapping("/adminUserEdit")
    public ModelAndView adminUserEdit() { return new ModelAndView("adminUserEdit"); }
    @GetMapping("/adminRoleList")
    public ModelAndView adminRoleList() { return new ModelAndView("adminRoleList"); }
    @GetMapping("/adminRoleEdit")
    public ModelAndView adminRoleEdit() { return new ModelAndView("adminRoleEdit"); }
    @GetMapping("/adminPermList")
    public ModelAndView adminPerList() { return new ModelAndView("adminPermList"); }
    @GetMapping("/adminPermEdit")
    public ModelAndView adminPermEdit() { return new ModelAndView("adminPermEdit"); }
    @GetMapping("/adminGoodList")
    public ModelAndView adminGoodList() { return new ModelAndView("adminGoodList"); }
    @GetMapping("/adminGoodEdit")
    public ModelAndView adminGoodEdit() { return new ModelAndView("adminGoodEdit"); }
    @GetMapping("/adminOrderList")
    public ModelAndView adminOrderList() { return new ModelAndView("adminOrderList"); }
}
