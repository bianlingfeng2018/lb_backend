package com.libiao.customer.repository;

import com.libiao.customer.dal.model.Permission;
import java.util.List;

public interface PermissionRepository {

  Permission findByPath(String path);

  List<Permission> selectAll();

  void insert(Permission permission);

  void deleteByPrimaryKey(Long permissionId);

  void updateByPrimaryKey(Permission permission);

  Permission selectByPrimaryKey(Long id);
}
