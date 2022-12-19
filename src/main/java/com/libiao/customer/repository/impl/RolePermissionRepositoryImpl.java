package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.RolePermissionMapper;
import com.libiao.customer.dal.model.RolePermission;
import com.libiao.customer.repository.RolePermissionRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class RolePermissionRepositoryImpl implements RolePermissionRepository {

  private final RolePermissionMapper rolePermissionMapper;

  public RolePermissionRepositoryImpl(RolePermissionMapper rolePermissionMapper) {
    this.rolePermissionMapper = rolePermissionMapper;
  }

  @Override
  public int insert(Long roleId, Long permissionId) {
    return rolePermissionMapper.insert(roleId, permissionId);
  }

  @Override
  public int deleteAllPermissionByPrimaryKey(Long id) {
    return rolePermissionMapper.deleteAllPermissionByPrimaryKey(id);
  }

  @Override
  public List<RolePermission> selectByRoleId(Long id) {
    return rolePermissionMapper.selectByRoleId(id);
  }
}
