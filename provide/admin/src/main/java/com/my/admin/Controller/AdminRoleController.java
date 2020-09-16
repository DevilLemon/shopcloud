package com.my.admin.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "管理角色列表控制器",description = "管理角色列表描述信息")
public class AdminRoleController {
    @Autowired
    private RoleService roleService;
    //常规角色列表页方法
    @GetMapping("/adminRole")
    @ApiOperation(value = "角色列表查询方法",notes = "角色列表查询备注")
    public PageInfo<Role> roleList(
        @RequestParam(value = "start",defaultValue = "1") int start,
        @RequestParam(value = "size",defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "roleid DESC");
        List<Role> adminRoleList = roleService.adminRoleList();
        PageInfo<Role> adminRoleInfo = new PageInfo<>(adminRoleList);
        return adminRoleInfo;
    }
    @PostMapping("/adminRole")
    @ApiOperation(value = "角色新增方法",notes = "角色新增备注")
    public String add(@RequestBody Role role) throws Exception {
        System.out.println("要添加的角色:" + role);
        roleService.addRole(role);
        return "Success";
    }
    @DeleteMapping("/adminRole/{roleid}")
    @ApiOperation(value = "角色删除方法",notes = "角色删除备注")
    public String deleteRole(@PathVariable Long roleid) throws Exception {
        System.out.println("要删除的角色:" + roleid);
        roleService.deleteRole(roleid);
        return "Success";
    }
    //角色编辑页方法
    @GetMapping("/adminRoleEdit/{userid}")
    @ApiOperation(value = "个人角色列表查询方法",notes = "个人角色列表查询备注")
    public UserRole adminRoleEdit(@PathVariable Long userid) throws Exception {
        UserRole userRole = roleService.getUserRole(userid);
        return userRole;
    }
    @PutMapping("/adminRoleEdit/{urid}")
    @ApiOperation(value = "个人角色更新方法",notes = "个人角色更新备注")
    public String updateUserRole(@RequestBody UserRole userRole) throws Exception {
        System.out.println("要更新的角色:" + userRole);
        roleService.updateUserRole(userRole);
        return "Success";
    }
}*/