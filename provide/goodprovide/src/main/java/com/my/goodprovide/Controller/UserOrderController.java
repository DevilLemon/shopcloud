package com.my.goodprovide.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.goodprovide.Service.OrderService;
import com.my.goodprovide.pobject.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserOrderController {
    @Autowired
    private OrderService orderService;
    //UserGood专用
    @GetMapping("/userOrder")
    public PageInfo<Order> orderList(
        @RequestParam(value = "start", defaultValue = "1") int start,
        @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "orderid DESC");
        List<Order> userOrderList = orderService.userOrderList(name);//返回分页集合
        PageInfo<Order> userOrderInfo = new PageInfo<>(userOrderList);//根据返回集合创建PageInfo对象
        System.out.println("订单列表:" + userOrderInfo);
        return userOrderInfo;
    }
    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) throws Exception {
        orderService.saveUserOrder(order);
        System.out.println("要新增的订单:" + order);
        return "userOrderList";
    }
    @DeleteMapping("/userOrder/{orederid}")
    public String deleteUserOrder(@PathVariable("orederid")int orederid) throws Exception {
        System.out.println("要删除的订单ID:" + orederid);
        orderService.deleteUserOrder(orederid);
        return "userOrderList";
    }
    @PutMapping("/userOrder/{orederid}")
    public String updateUserOrder(@RequestBody Order order) throws Exception {
        System.out.println("要更新的订单ID:" + order);
        orderService.updateUserOrder(order);
        return "userOrderList";
    }
}*/