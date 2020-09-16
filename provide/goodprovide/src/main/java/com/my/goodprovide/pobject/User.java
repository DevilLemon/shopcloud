package com.my.goodprovide.pobject;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable{
    private Long userid;
    private String name;
    private String password;
    private String repeatpass;
    private String salt;
}
