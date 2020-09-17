package com.my.goodprovide.Service;

import com.my.goodprovide.Client.Feign;
import com.my.goodprovide.pobject.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    Feign feign;
    public List<Good> userGoodList() {return feign.goodList();}
    public Good getGood(Long goodid) {return feign.getGood(goodid);}
}
