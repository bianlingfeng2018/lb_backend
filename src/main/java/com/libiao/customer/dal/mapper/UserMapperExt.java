package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.UserExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperExt {

    int deleteByPrimaryKey(Long id);

    int insert(UserExt row);

    UserExt selectByPrimaryKey(Long id);

    UserExt selectByUsernamePassword(@Param("username") String username, @Param("password") String password);

    List<UserExt> selectAll();

    int updateByPrimaryKey(UserExt row);

    List<UserExt> selectAllWithRole();

    List<UserExt> selectAllWithRoleByRole(@Param("role") String role);

  UserExt selectByUsername(@Param("username") String userName);

  List<UserExt> selectAllWithRoleByRoleAndCreatedBy(@Param("role") String roleName,
                                                    @Param("id") Long id);

  List<UserExt> selectAllWithRoleByRoleInSameTestTrade(@Param("role") String roleName,
                                                       @Param("username") String loginUsername);

  UserExt selectByRoleAndTestTrade(@Param("role") String role, @Param("tradeId") Long tradeId);

  List<UserExt> selectAllWithRoleByNotRole(@Param("role") String role);

  UserExt selectByPrimaryKeyWithRole(@Param("id") Long id);

  List<UserExt> selectByClientId(@Param("id") Long id);

  List<UserExt> selectByPhoneNum(@Param("phoneNum") String phoneNum);
}
