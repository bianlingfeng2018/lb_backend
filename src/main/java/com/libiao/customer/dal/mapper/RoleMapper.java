package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Role;
import java.util.List;

public interface RoleMapper {

  List<Role> selectAll();

  List<Role> selectAllWithPermission();

  int updateByPrimaryKey(Role role);

  int deleteByPrimaryKey(Long id);

  int insert(Role role);

  Role selectByKey(Long id);

  Role selectByRoleName(String name);
}
