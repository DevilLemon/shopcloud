package com.my.admin.Client;

import com.my.admin.Client.Hystrix.Hystrix;
import com.my.admin.pobject.Good;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "PRODUCT",fallback = Hystrix.class) //管理员feign端
public interface Feign {
    //Admin部分
    @PostMapping("/adminGood")
    int addGood(@RequestBody Good good);
}