package com.libiao.customer.entity;

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


}
