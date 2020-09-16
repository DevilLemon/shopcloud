package com.my.goodprovide.Client.Hystrix;

import com.my.goodprovide.Client.Feign;
import com.my.goodprovide.pobject.Good;
import com.my.goodprovide.pobject.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class Hystrix implements Feign {
    @Override
    public List<Good> goodList(){
        return null;
    }
    @Override
    public User login_check(@RequestParam("name") String name){
        return null;
    }
    @Override
    public int addGood(@RequestBody Good good){
        return 0;
    }
}