package com.libiao.customer.entity;

import com.libiao.customer.dal.model.Role;
import lombok.Data;

import java.io.Serializable;

@Data
public class SessionUser implements Serializable {

    private long id;

    private String username;

    private String permission;

    private String nickname;

    private String phoneNum;

    private String email;

    private String status;

    private String orgNo;

    private Integer discount;//折扣

}
