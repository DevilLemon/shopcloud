package com.my.goodprovide.Client.Hystrix;

import com.my.goodprovide.Client.Feign;
import com.my.goodprovide.pobject.Cart;
import com.my.goodprovide.pobject.Good;
import com.my.goodprovide.pobject.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component //用户Hystrix端
public class Hystrix implements Feign {
    @Override //公共兜底
    public User login_check(@RequestParam("name") String name){
        return null;
    }
    @Override
    public User register(@RequestBody User user){
        return null;
    }
    @Override //UserGood部分
    public List<Good> goodList(){ return null; }
    @Override
    public Good getGood(Long goodid){ return null; }
    @Override //UserCart部分
    public List<Cart> userCartList(String name){ return null; }
    @Override
    public void saveCart(Cart cart){};
    @Override
    public void deleteCart(Long cartid){};
    @Override
    public void updateCart(Cart cart){};
}