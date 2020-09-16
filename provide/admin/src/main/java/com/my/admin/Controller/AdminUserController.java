package com.my.admin.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "管理用户列表控制器",description = "管理用户列表描述信息")
public class AdminUserController {
    @Autowired
    private UserService userService;
    //常规用户管理列表
    @GetMapping("/adminUser")
    @ApiOperation(value = "用户列表查询方法",notes = "用户列表查询备注")
    public PageInfo<User> userList(
        @RequestParam(value = "start",defaultValue = "1") int start,
        @RequestParam(value = "size",defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(1, 5, "userid DESC");
        List<User> adminUserList = userService.adminUserList();
        PageInfo<User> adminUserInfo = new PageInfo<>(adminUserList);
        return adminUserInfo;
    }
    @PostMapping("/adminUser")
    @ApiOperation(value = "新增用户方法",notes = "新增用户备注")
    public String add(@RequestBody Long userid)  throws Exception {
        System.out.println("要添加的user:" + userid);
        userService.deleteUser(userid);
        return "success";
    }
    @DeleteMapping("/adminUser/{userid}")
    @ApiOperation(value = "删除用户方法",notes = "删除用户备注")
    public String deleteUser(@PathVariable Long userid)  throws Exception {
        System.out.println("要删除的user:" + userid);
        userService.deleteUser(userid);
        return "success";
    }
    @PutMapping("/resetPass/{userid}")
    @ApiOperation(value = "重置用户密码方法",notes = "重置用户密码备注")
    public String resetPass(Long userid)  throws Exception {
        System.out.println("要重置密码的user:" + userid);
        userService.resetPass(userid);
        return "success";
    }
    @PutMapping("/adminUser/{userid}")
    @ApiOperation(value = "更新用户账号密码方法",notes = "更新用户账号密码备注")
    public String update(User user)  throws Exception {
        System.out.println("要更新的user:" + user);
        userService.updateUser(user);
        return "success";
    }
    //用户编辑页
    @GetMapping("/adminUserEdit/{userid}")
    @ApiOperation(value = "查询单个用户信息方法",notes = "查询单个用户信息备注")
    public UserInfo adminUserEdit(@PathVariable Long userid) throws Exception {
        UserInfo userInfo = userService.getUserInfo(userid);
        System.out.println("查询到的个人信息:" + userInfo);
        return userInfo;
    }
    @PutMapping("/adminUserEdit/{infoid}")
    @ApiOperation(value = "修改单个用户信息方法",notes = "修改单个用户信息备注")
    public String updateUserInfo(@RequestBody UserInfo userInfo)  throws Exception {
        System.out.println("要修改的个人信息:" + userInfo);
        userService.updateUserInfo(userInfo);
        return "success";
    }
}*/