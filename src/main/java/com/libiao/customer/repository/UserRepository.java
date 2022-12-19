package com.libiao.customer.repository;

import com.libiao.customer.dal.model.User;
import java.util.List;

public interface UserRepository {

  int deleteByPrimaryKey(Long id);

  int insert(User row);

  User selectByPrimaryKey(Long id);

  User selectByUsernamePassword(String username, String password);

  List<User> selectAll();

  int updateByPrimaryKey(User row);

  List<User> selectAllWithRole();

  List<User> selectAllWithRoleByRole(String role);

  User selectByUsername(String userName);

  List<User> selectAllWithRoleByRoleAndCreatedBy(String roleName, Long id);

  List<User> selectAllWithRoleByRoleInSameTestTrade(String role, String loginUsername);

  User selectByRoleAndTestTrade(String role, Long tradeId);

  List<User> selectAllWithRoleByNotRole(String role);

  User selectByPrimaryKeyWithRole(Long id);

  List<User> selectByClientId(Long id);

  List<User> selectByPhoneNum(String phoneNum);
}
