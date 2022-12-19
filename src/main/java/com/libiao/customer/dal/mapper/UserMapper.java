package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User row);

    User selectByPrimaryKey(Long id);

    User selectByUsernamePassword(@Param("username") String username, @Param("password") String password);

    List<User> selectAll();

    int updateByPrimaryKey(User row);

    List<User> selectAllWithRole();

    List<User> selectAllWithRoleByRole(@Param("role") String role);

  User selectByUsername(@Param("username") String userName);

  List<User> selectAllWithRoleByRoleAndCreatedBy(@Param("role") String roleName,
      @Param("id") Long id);

  List<User> selectAllWithRoleByRoleInSameTestTrade(@Param("role") String roleName,
      @Param("username") String loginUsername);

  User selectByRoleAndTestTrade(@Param("role") String role, @Param("tradeId") Long tradeId);

  List<User> selectAllWithRoleByNotRole(@Param("role") String role);

  User selectByPrimaryKeyWithRole(@Param("id") Long id);

  List<User> selectByClientId(@Param("id") Long id);

  List<User> selectByPhoneNum(@Param("phoneNum") String phoneNum);
}
