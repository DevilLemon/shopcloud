package com.my.goodprovide.Service;

import com.my.goodprovide.Client.Feign;
import com.my.goodprovide.pobject.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    Feign feign;
    public List<Cart> userCartList(String name){ return feign.userCartList(name); };
    public void saveCart(Cart cart){ feign.saveCart(cart); };
    public void deleteCart(Long cartid){ feign.deleteCart(cartid); };
    public void updateCart(Cart cart){ feign.updateCart(cart); };
}
