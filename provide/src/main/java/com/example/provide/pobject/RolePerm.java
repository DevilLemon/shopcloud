package com.example.provide.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RolePerm {
    private Long urpid;
    private Long userid;
    private String name;
    private Long roleid;
    private String role;
    private Long permid;
    private String perm;
}
