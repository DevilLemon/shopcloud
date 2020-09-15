package com.my.product.Service;

import com.my.product.MyObject.Good;

import java.util.List;

public interface GoodService {
    List<Good> userGoodList();
    int addGood(Good good);
}
