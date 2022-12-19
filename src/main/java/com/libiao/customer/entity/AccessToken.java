package com.libiao.customer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang Xu
 * @date 2022/6/28
 */
@Data
@NoArgsConstructor
public class AccessToken {

    private String token;
    private String username;
    private String password;
    private String permission;
    public AccessToken(String token) {
        this.token = token;
    }

}