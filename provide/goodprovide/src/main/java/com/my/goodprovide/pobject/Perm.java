package com.my.goodprovide.pobject;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Perm {
    private Long permid;
    private String perm;
    private String url;
}
