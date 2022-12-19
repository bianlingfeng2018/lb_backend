package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.UserMapper;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserMapper userMapper;

  public UserRepositoryImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }


  @Override
  public List<User> selectAll() {
    return userMapper.selectAll();
  }

  @Override
  public List<User> selectAllWithRole() {
    return userMapper.selectAllWithRole();
  }

  @Override
  public List<User> selectAllWithRoleByRole(String role) {
    return userMapper.selectAllWithRoleByRole(role);
  }

  @Override
  public User selectByUsername(String userName) {
    return userMapper.selectByUsername(userName);
  }

  @Override
  public List<User> selectAllWithRoleByRoleAndCreatedBy(String roleName, Long id) {
    return userMapper.selectAllWithRoleByRoleAndCreatedBy(roleName, id);
  }

  @Override
  public List<User> selectAllWithRoleByRoleInSameTestTrade(String roleName, String loginUsername) {
    return userMapper.selectAllWithRoleByRoleInSameTestTrade(roleName, loginUsername);
  }

  @Override
  public User selectByRoleAndTestTrade(String role, Long tradeId) {
    return userMapper.selectByRoleAndTestTrade(role, tradeId);
  }

  @Override
  public List<User> selectAllWithRoleByNotRole(String role) {
    return userMapper.selectAllWithRoleByNotRole(role);
  }

  @Override
  public User selectByPrimaryKeyWithRole(Long id) {
    return userMapper.selectByPrimaryKeyWithRole(id);
  }

  @Override
  public List<User> selectByClientId(Long id) {
    return userMapper.selectByClientId(id);
  }

  @Override
  public List<User> selectByPhoneNum(String phoneNum) {
    return userMapper.selectByPhoneNum(phoneNum);
  }

  @Override
  public User selectByPrimaryKey(Long id) {
    return userMapper.selectByPrimaryKey(id);
  }

  @Override
  public User selectByUsernamePassword(String username, String password) {
    return userMapper.selectByUsernamePassword(username, password);
  }

  @Override
  public int deleteByPrimaryKey(Long id) {
    return userMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(User user) {
    return userMapper.insert(user);
  }

  @Override
  public int updateByPrimaryKey(User row) {
    return userMapper.updateByPrimaryKey(row);
  }

}
