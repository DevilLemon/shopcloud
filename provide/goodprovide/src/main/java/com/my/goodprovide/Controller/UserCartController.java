package com.my.goodprovide.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.goodprovide.Service.CartService;
import com.my.goodprovide.pobject.Cart;
import com.my.goodprovide.pobject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserCartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/userCart")
    public PageInfo<Cart> cartList(HttpSession session,
        @RequestParam(value = "start", defaultValue = "1", required = true) int start,
        @RequestParam(value = "size", defaultValue = "5", required = true) int size) throws Exception {
        User user = (User)session.getAttribute("user");
        System.out.println("购物车获取Session：" +user);
        PageHelper.startPage(start, size, "cartid DESC");
        List<Cart> userCartList = cartService.userCartList(user.getName());
        PageInfo<Cart> userCartMyInfo = new PageInfo<>(userCartList);
        System.out.println("返回的数据列表:" + userCartMyInfo);
        return userCartMyInfo;
    }
    @PostMapping("/addCart")
    public String saveCart(@RequestBody Cart cart) throws Exception {
        cartService.saveCart(cart);
        System.out.println("要新增的购物车商品:" + cart);
        return "success";
    }
    @DeleteMapping("/userCart/{cartid}")
    public String deleteCart(@PathVariable("cartid")Long cartid) throws Exception {
        System.out.println("要删除的购物车商品:" + cartid);
        cartService.deleteCart(cartid);
        return "success";
    }
    @PutMapping("/userCart/{cartid}")
    public String updateCart(@RequestBody Cart cart) throws Exception {
        System.out.println("要更新的购物车商品:" + cart);
        cartService.updateCart(cart);
        return "success";
    }
}