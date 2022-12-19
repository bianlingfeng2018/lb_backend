package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.RoleMapper;
import com.libiao.customer.dal.model.Role;
import com.libiao.customer.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  private final RoleMapper roleMapper;

  public RoleRepositoryImpl(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }

  @Override
  public List<Role> selectAllWithPermission() {
    return roleMapper.selectAllWithPermission();
  }

  @Override
  public int updateByPrimaryKey(Role role) {
    return roleMapper.updateByPrimaryKey(role);
  }

  @Override
  public int deleteByPrimaryKey(Long id) {
    return roleMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(Role row) {
    return roleMapper.insert(row);
  }

  @Override
  public List<Role> selectAll() {
    return roleMapper.selectAll();
  }

  @Override
  public Role selectByPrimaryKey(Long id) {
    return roleMapper.selectByKey(id);
  }

  @Override
  public Role selectByRoleName(String roleName) {
    return roleMapper.selectByRoleName(roleName);
  }

}
