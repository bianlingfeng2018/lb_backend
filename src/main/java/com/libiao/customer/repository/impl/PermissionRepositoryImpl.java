package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.PermissionMapper;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.repository.PermissionRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class PermissionRepositoryImpl implements PermissionRepository {

  final private PermissionMapper permissionMapper;

  public PermissionRepositoryImpl(PermissionMapper permissionMapper) {
    this.permissionMapper = permissionMapper;
  }

  @Override
  public Permission findByPath(String path) {
    return permissionMapper.selectByPath(path);
  }

  @Override
  public List<Permission> selectAll() {
    return permissionMapper.selectAll();
  }

  @Override
  public void insert(Permission permission) {
    permissionMapper.insert(permission);
  }

  @Override
  public void deleteByPrimaryKey(Long permissionId) {
    permissionMapper.deleteByPrimaryKey(permissionId);
  }

  @Override
  public void updateByPrimaryKey(Permission permission) {
    permissionMapper.updateByPrimaryKey(permission);
  }

  @Override
  public Permission selectByPrimaryKey(Long id) {
    return permissionMapper.selectByPrimaryKey(id);
  }
}
