package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Permission;
import java.util.List;

public interface PermissionMapper {

  Permission selectByPath(String path);

  List<Permission> selectAll();

  void insert(Permission permission);

  void deleteByPrimaryKey(Long id);

  void updateByPrimaryKey(Permission permission);

  Permission selectByPrimaryKey(Long id);
}
