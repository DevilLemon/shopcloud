package com.example.provide.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cart {
    private Long cartid;
    private String username;
    private String name;
    private int num;
    private int pay;
    private int allpay;
    private String status;
}
