package com.example.provide.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRole {
    private Long urid;
    private Long userid;
    private String name;
    private Long roleid;
    private String role;
}
