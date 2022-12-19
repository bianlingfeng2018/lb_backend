package com.libiao.customer.service;

import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.Role;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface UserRolePermissionService {

  ResponseVO<Void> addPermission(Permission permission);

  ResponseVO<PageVO<User>> getUsersByPage(int pageNo, int pageSize);

  ResponseVO<List<User>> getAllUsers();

  ResponseVO<PageVO<Role>> getRolesByPage(int pageNo, int pageSize);

  ResponseVO<Void> deleteUser(Long userId);

  ResponseVO<Void> deletePermission(Long permissionId);

  ResponseVO<Void> deleteRole(Long roleId);

  ResponseVO<Void> addUser(User user);

  ResponseVO<Void> addRole(Role role);

  ResponseVO<Void> updateUser(User user);

  ResponseVO<Void> updatePermission(Permission permission);

  ResponseVO<Void> updateRole(Role role);

  ResponseVO<List<Role>> getAllRoles();

  ResponseVO<PageVO<Role>> getPermissionByPage(int pageNo, int pageSize);

  ResponseVO<List<User>> getAllClientsByOwner(String role);

  ResponseVO<PageVO<User>> getClientsByPageAndOwner(int pageNo, int pageSize, String role);

  ResponseVO<List<User>> getAllUsersByRole(String role);

  ResponseVO<User> getUserByUsername(String username);

  ResponseVO<?> updateUserPassword(String username, String oldPassword, String newPassword);

  ResponseVO<?> getUserById(Long id);

  ResponseVO<User> getUserByRoleAndTradeId(String role, Long tradeId);

  ResponseVO<?> uploadSignature(MultipartFile[] imgList, String username);

  ResponseVO<?> getUserSignatures(String username);

  ResponseVO<PageVO<User>> getEmployeePage(int pageNo, int pageSize);
}
