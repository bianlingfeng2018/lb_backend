package com.libiao.customer.service;

import com.libiao.customer.dal.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserByRoleId(Long roleId);
}
