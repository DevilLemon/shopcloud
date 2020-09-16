package com.my.admin.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "管理权限列表控制器",description = "管理权限列表描述信息")
public class AdminPermController {
    @Autowired
    private PermissionService permissionService;
    //管理全局权限页列表方法
    @GetMapping("/adminPerm")
    @ApiOperation(value = "权限列表查询方法",notes = "权限列表查询备注")
    public PageInfo<Perm> adminPermList(
        @RequestParam(value = "start", defaultValue = "1") int start,
        @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "permid DESC");
        List<Perm> adminPermList = permissionService.adminPermList();
        PageInfo<Perm> adminPerInfo = new PageInfo<>(adminPermList);
        return adminPerInfo;
    }
    //管理用户个人的权限编辑页方法
    @GetMapping("/adminPermEdit/{userid}")
    @ApiOperation(value = "个人权限列表查询方法",notes = "个人权限列表查询备注")
    public PageInfo<RolePerm> adminRoleEdit(@PathVariable Long userid,
                                            @RequestParam(value = "start", defaultValue = "1") int start,
                                            @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "p.permid DESC");
        List<RolePerm> userPermList = permissionService.UserPermList(userid);
        PageInfo<RolePerm> userPermInfo = new PageInfo<>(userPermList,size);
        System.out.println("查询用户的全部权限:" + userPermInfo);
        return userPermInfo;
    }
    @PutMapping("/adminPermEdit")
    @ApiOperation(value = "个人角色更新方法",notes = "个人角色更新查询备注")
    public String updateUserPerm(@RequestBody RolePerm rolePerm) throws Exception {
        System.out.println("要更新的角色:" + rolePerm);
        permissionService.updateUserPerm(rolePerm);
        return "Success";
    }
    @DeleteMapping("/adminPermEdit/{urpid}")
    @ApiOperation(value = "个人权限删除方法",notes = "个人权限删除备注")
    public String deleteUserPerm(@PathVariable Long urpid) throws Exception {
        System.out.println("要删除的权限ID:" + urpid);
        permissionService.deleteUserPerm(urpid);
        return "Success";
    }
}*/