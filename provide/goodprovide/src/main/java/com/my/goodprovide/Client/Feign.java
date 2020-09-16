package com.my.goodprovide.Client;

import com.my.goodprovide.Client.Hystrix.Hystrix;
import com.my.goodprovide.pobject.Good;
import com.my.goodprovide.pobject.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "PRODUCT",fallback = Hystrix.class)
public interface Feign {
    @GetMapping("/userGood")
    List<Good> goodList();
    @PostMapping("/adminGood")
    int addGood(@RequestBody Good good);
    @PostMapping("/login")
    User login_check(@RequestParam("name") String name);
}