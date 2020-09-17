package com.my.goodprovide.Client;

import com.my.goodprovide.Client.Hystrix.Hystrix;
import com.my.goodprovide.pobject.Cart;
import com.my.goodprovide.pobject.Good;
import com.my.goodprovide.pobject.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "PRODUCT",fallback = Hystrix.class) //用户feign端
public interface Feign {
    //公用部分
    @PostMapping("/login")
    User login_check(@RequestParam("name") String name);
    @PostMapping("/register")
    User register(@RequestBody User user);
    //UserGood
    @GetMapping("/userGood")
    List<Good> goodList();
    @GetMapping("/userGetGood")
    Good getGood(@RequestBody Long goodid);
    //UserCart
    @GetMapping("/userCart")
    List<Cart> userCartList(String name);
    @PostMapping("/addCart")
    void saveCart(Cart cart);
    @DeleteMapping("/userCart/{cartid}")
    void deleteCart(Long cartid);
    @PutMapping("/userCart/{cartid}")
    void updateCart(Cart cart);
}