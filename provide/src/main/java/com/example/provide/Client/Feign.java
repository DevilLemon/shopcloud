package com.example.provide.Client;

import com.example.provide.Client.Hystrix.Hystrix;
import com.example.provide.pobject.Good;
import com.example.provide.pobject.User;
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