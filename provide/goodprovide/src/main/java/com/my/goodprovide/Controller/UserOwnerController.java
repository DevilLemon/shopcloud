package com.my.goodprovide.Controller;
/*
import com.my.goodprovide.Service.UserService;
import com.my.goodprovide.pobject.User;
import com.my.goodprovide.pobject.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserOwnerController {
    @Autowired
    private UserService userService;
    //用户个人信息页
    @GetMapping("/userOwnerList/{name}")
    public UserInfo adminUserEdit(@PathVariable String name) throws Exception {
        UserInfo userInfo = userService.getUserInfo(userService.getUserID(name));
        System.out.println("查询到的个人信息:" + userInfo);
        return userInfo;
    }
    @PostMapping("/userOwnerList")
    public String add(@RequestBody User user)  throws Exception {
        System.out.println("要添加的个人信息:" + user);
        userService.updateUser(user);
        return "success";
    }
    @DeleteMapping("/userOwnerList/{userid}")
    public String deleteUser(@PathVariable Long userid)  throws Exception {
        System.out.println("要删除的user:" + userid);
        userService.deleteUser(userid);
        return "success";
    }
    @PutMapping("/userOwnerList/{userid}")
    public String resetPass(@RequestBody User user)  throws Exception {
        System.out.println("要更新的个人信息:" + user);
        userService.updateUser(user);
        return "success";
    }
}*/