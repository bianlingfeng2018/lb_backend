package com.libiao.customer.repository;

import com.libiao.customer.dal.model.RolePermission;
import java.util.List;

public interface RolePermissionRepository {

  int insert(Long roleId, Long permissionId);

  int deleteAllPermissionByPrimaryKey(Long id);

  List<RolePermission> selectByRoleId(Long id);
}
