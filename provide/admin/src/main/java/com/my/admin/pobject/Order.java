package com.my.admin.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
    private Long orderid;
    private String username;
    private String name;
    private int num;
    private int allpay;
    private String status;
}
