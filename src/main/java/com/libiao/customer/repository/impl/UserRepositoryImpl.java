package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.UserMapperExt;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final UserMapperExt userMapperExt;

  public UserRepositoryImpl(UserMapperExt userMapperExt) {
    this.userMapperExt = userMapperExt;
  }


  @Override
  public List<UserExt> selectAll() {
    return userMapperExt.selectAll();
  }

  @Override
  public List<UserExt> selectAllWithRole() {
    return userMapperExt.selectAllWithRole();
  }

  @Override
  public List<UserExt> selectAllWithRoleByRole(String role) {
    return userMapperExt.selectAllWithRoleByRole(role);
  }

  @Override
  public UserExt selectByUsername(String userName) {
    return userMapperExt.selectByUsername(userName);
  }

  @Override
  public List<UserExt> selectAllWithRoleByRoleAndCreatedBy(String roleName, Long id) {
    return userMapperExt.selectAllWithRoleByRoleAndCreatedBy(roleName, id);
  }

  @Override
  public List<UserExt> selectAllWithRoleByRoleInSameTestTrade(String roleName, String loginUsername) {
    return userMapperExt.selectAllWithRoleByRoleInSameTestTrade(roleName, loginUsername);
  }

  @Override
  public UserExt selectByRoleAndTestTrade(String role, Long tradeId) {
    return userMapperExt.selectByRoleAndTestTrade(role, tradeId);
  }

  @Override
  public List<UserExt> selectAllWithRoleByNotRole(String role) {
    return userMapperExt.selectAllWithRoleByNotRole(role);
  }

  @Override
  public UserExt selectByPrimaryKeyWithRole(Long id) {
    return userMapperExt.selectByPrimaryKeyWithRole(id);
  }

  @Override
  public List<UserExt> selectByClientId(Long id) {
    return userMapperExt.selectByClientId(id);
  }

  @Override
  public List<UserExt> selectByPhoneNum(String phoneNum) {
    return userMapperExt.selectByPhoneNum(phoneNum);
  }

  @Override
  public UserExt selectByPrimaryKey(Long id) {
    return userMapperExt.selectByPrimaryKey(id);
  }

  @Override
  public UserExt selectByUsernamePassword(String username, String password) {
    return userMapperExt.selectByUsernamePassword(username, password);
  }

  @Override
  public int deleteByPrimaryKey(Long id) {
    return userMapperExt.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(UserExt userExt) {
    return userMapperExt.insert(userExt);
  }

  @Override
  public int updateByPrimaryKey(UserExt row) {
    return userMapperExt.updateByPrimaryKey(row);
  }

}
