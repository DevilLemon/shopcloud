package com.example.provide.Service;

import com.example.provide.Client.Feign;
import com.example.provide.pobject.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    Feign feign;
    public List<Good> userGoodList() {return feign.goodList();}
    public int addGood(Good good) {return feign.addGood(good);}
}
