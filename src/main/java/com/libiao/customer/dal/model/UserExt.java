package com.libiao.customer.dal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExt {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtModify;

    private String username;

    private String password;

    private String permission;

    private String nickname;

    private String phoneNum;

    private String email;

    private String status;

    private String sex;

    private String accountType;

    private Role role;

    private Long createdBy;

    private String com;

    private Long comId;

    private String flexObj;
    private String phone;
    private String decideRole;
    private String depart;
    private String orgNo;
    private String city;
    private String pos;
    private String workState;
    private String birthday;
    private String mainContact;
}
//    private String phone;
//    private String decide_role;
//    private String depart;
//    private String pos;
//    private String work_state;
//    private String birthday;
//    private String main_contact;
