package com.libiao.customer.repository;

import com.libiao.customer.dal.model.UserExt;

import java.util.List;

public interface UserRepository {

  int deleteByPrimaryKey(Long id);

  int insert(UserExt row);

  UserExt selectByPrimaryKey(Long id);

  UserExt selectByUsernamePassword(String username, String password);

  List<UserExt> selectAll();

  int updateByPrimaryKey(UserExt row);

  List<UserExt> selectAllWithRole();

  List<UserExt> selectAllWithRoleByRole(String role);

  UserExt selectByUsername(String userName);

  List<UserExt> selectAllWithRoleByRoleAndCreatedBy(String roleName, Long id);

  List<UserExt> selectAllWithRoleByRoleInSameTestTrade(String role, String loginUsername);

  UserExt selectByRoleAndTestTrade(String role, Long tradeId);

  List<UserExt> selectAllWithRoleByNotRole(String role);

  UserExt selectByPrimaryKeyWithRole(Long id);

  List<UserExt> selectByClientId(Long id);

  List<UserExt> selectByPhoneNum(String phoneNum);
}
