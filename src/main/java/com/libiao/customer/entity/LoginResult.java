package com.libiao.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginResult {
    String status;
    String type;
    String currentAuthority;
}
