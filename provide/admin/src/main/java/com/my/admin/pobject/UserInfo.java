package com.my.admin.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {
    private Long ufid;
    private Long userid;
    private Long infoid;
    private String name;
    private String sex;
    private String nation;
    private String phone;
    private String address;
}
