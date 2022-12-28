package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.UserMapper;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.dal.model.UserExample;
import com.libiao.customer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByRoleId(Long roleId){
        final UserExample userExample = new UserExample();
        userExample.createCriteria().andRoleIdEqualTo(roleId);
        return userMapper.selectByExample(userExample);
    }
}
