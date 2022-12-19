package com.libiao.customer.dal.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

    private Long id; // 角色id

    private String name;  // 角色名称

    private String desc;

    private List<Permission> permission;
}
