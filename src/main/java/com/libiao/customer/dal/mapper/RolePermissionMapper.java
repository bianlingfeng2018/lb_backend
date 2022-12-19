package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.RolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {

  int deleteAllPermissionByPrimaryKey(Long id);

  int insert(@Param(value = "roleId") Long roleId,
      @Param(value = "permissionId") Long permissionId);

  List<RolePermission> selectByRoleId(Long id);
}
