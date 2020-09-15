package com.my.product.Service.impl;

import com.my.product.Mapper.GoodMapper;
import com.my.product.MyObject.Good;
import com.my.product.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<Good> userGoodList() {
        return goodMapper.userGoodList();
    }
    @Override
    public int addGood(Good good) {
        return goodMapper.addGood(good);
    }
}
