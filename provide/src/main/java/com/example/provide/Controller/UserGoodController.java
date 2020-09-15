package com.example.provide.Controller;

import com.example.provide.Service.GoodService;
import com.example.provide.pobject.Good;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class UserGoodController {
    @Autowired
    private GoodService goodService;
    @Value("${server.port}")
    String port;
    @GetMapping("/userGood")
    public PageInfo<Good> goodList(@RequestParam(value = "start",defaultValue = "1") int start,
                                   @RequestParam(value = "size",defaultValue = "5") int size,HttpSession session){
        PageHelper.startPage(start, size,"goodid DESC");
        List<Good> goodList = goodService.userGoodList();
        PageInfo<Good> userGoodInfo = new PageInfo<>(goodList,size);//根据返回集合创建PageInfo对象
        System.out.println("远程获取数据：" + userGoodInfo);
        System.out.println("获取数据的服务端口：" + port);
        return userGoodInfo;
    }
    @PostMapping("/adminGood")
    public String add(@RequestBody Good good) throws Exception {
        System.out.println("要添加的商品:" + good);
        goodService.addGood(good);
        return "Success";
    }
}