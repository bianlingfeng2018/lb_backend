package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.RolePermissionMapper;
import com.libiao.customer.dal.mapper.UserTestTradeMapper;
import com.libiao.customer.dal.model.RolePermission;
import com.libiao.customer.repository.RolePermissionRepository;
import com.libiao.customer.repository.UserTestTradeRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class UserTestTradeRepositoryImpl implements UserTestTradeRepository {

  private final UserTestTradeMapper userTestTradeMapper;

  public UserTestTradeRepositoryImpl(UserTestTradeMapper userTestTradeMapper) {
    this.userTestTradeMapper = userTestTradeMapper;
  }

  @Override
  public int insert(Long roleId, Long permissionId) {
    return userTestTradeMapper.insert(roleId, permissionId);
  }

  @Override
  public int deleteAllPermissionByTestTradeIdAndRole(Long testTradeId, String role) {
    return userTestTradeMapper.deleteAllPermissionByTestTradeIdAndRole(testTradeId, role);
  }

}
