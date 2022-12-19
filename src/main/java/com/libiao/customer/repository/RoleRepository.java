package com.libiao.customer.repository;

import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.Role;
import java.util.List;

public interface RoleRepository {

  List<Role> selectAllWithPermission();

  int updateByPrimaryKey(Role role);

  int deleteByPrimaryKey(Long roleId);

  int insert(Role role);

  List<Role> selectAll();

  Role selectByPrimaryKey(Long id);

  Role selectByRoleName(String roleName);
}
