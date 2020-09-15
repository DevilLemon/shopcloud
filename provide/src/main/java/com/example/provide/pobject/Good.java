package com.example.provide.pobject;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Good {
    private String img;
    private Long goodid;
    private String name;
    private int num;
    private int pay;
    private int allpay;
    private String status;
}
