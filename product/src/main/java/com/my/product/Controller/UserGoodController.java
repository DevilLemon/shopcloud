package com.my.product.Controller;

import com.my.product.MyObject.Good;
import com.my.product.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserGoodController{
    @Autowired
    private GoodService goodService;
    @GetMapping("/userGood")
    public List<Good> goodList(){
        List<Good> goodList = goodService.userGoodList();
        return goodList;
    }
    @PostMapping("/adminGood")
    public String add(@RequestBody Good good) throws Exception {
        System.out.println("要添加的商品:" + good);
        goodService.addGood(good);
        return "Success";
    }
    @GetMapping("/userGetGood")
    public Good get(@RequestBody Long goodid) throws Exception {
        System.out.println("数据中心查询商品ID:" + goodid);
        Good good = goodService.getGood(goodid);
        System.out.println("数据中心查询到的商品返回:" + good);
        return good;
    }
}