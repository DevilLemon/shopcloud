package com.my.admin.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "管理商品列表控制器",description = "管理商品列表描述信息")
public class AdminGoodController {
    @Autowired
    private GoodService goodService;
    @GetMapping("/adminGood")
    @ApiOperation(value = "商品列表查询方法",notes = "商品列表查询备注")
    public PageInfo<Good> goodList(
        @RequestParam(value = "start", defaultValue = "1") int start,
        @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "goodid DESC");
        List<Good> adminGoodList = goodService.adminGoodList();
        PageInfo<Good> adminGoodInfo = new PageInfo<>(adminGoodList,size);
        return adminGoodInfo;
    }
    @PostMapping("/adminGood")
    @ApiOperation(value = "添加商品方法",notes = "添加商品必须要输入商品名、数量、单价")
    public String add(@RequestBody Good good) throws Exception {
        System.out.println("要添加的商品:" + good);
        goodService.addGood(good);
        return "Success";
    }
    @DeleteMapping("/adminGood/{goodid}")
    @ApiOperation(value = "删除商品方法",notes = "只能根据选择的商品ID进行单个删除")
    public String delete(Good good) throws Exception {
        System.out.println("要删除的商品:" + good);
        goodService.deleteGood(good.getGoodid());
        return "Success";
    }
    @PutMapping("/adminGood/{goodid}")
    @ApiOperation(value = "更新商品方法",notes = "根据修改的商品信息进行更新")
    public String update(@RequestBody Good good) throws Exception {
        System.out.println("要更新的商品:" + good);
        goodService.updateGood(good);
        return "Success";
    }
    @GetMapping("/adminGood/{goodid}")
    @ApiOperation(value = "获取单个商品详情方法",notes = "根据所选商品ID进行查询")
    public Good get(@PathVariable("goodid") Long goodid) throws Exception {
        System.out.println("分离地址的goodid:" + goodid);
        Good good = goodService.getGood(goodid);
        return good;
    }
}*/