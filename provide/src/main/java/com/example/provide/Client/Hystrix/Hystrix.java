package com.example.provide.Client.Hystrix;

import com.example.provide.Client.Feign;
import com.example.provide.pobject.Good;
import com.example.provide.pobject.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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