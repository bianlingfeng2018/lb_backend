package com.libiao.customer.service;

import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.Role;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface UserRolePermissionService {

  ResponseVO<Void> addPermission(Permission permission);

  ResponseVO<PageVO<UserExt>> getUsersByPage(int pageNo, int pageSize);

  ResponseVO<List<UserExt>> getAllUsers();

  ResponseVO<PageVO<Role>> getRolesByPage(int pageNo, int pageSize);

  ResponseVO<Void> deleteUser(Long userId);

  ResponseVO<Void> deletePermission(Long permissionId);

  ResponseVO<Void> deleteRole(Long roleId);

  ResponseVO<Void> addUser(UserExt userExt);

  ResponseVO<Void> addRole(Role role);

  ResponseVO<Void> updateUser(UserExt userExt);

  ResponseVO<Void> updatePermission(Permission permission);

  ResponseVO<Void> updateRole(Role role);

  ResponseVO<List<Role>> getAllRoles();

  ResponseVO<PageVO<Role>> getPermissionByPage(int pageNo, int pageSize);

  ResponseVO<List<UserExt>> getAllClientsByOwner(String role);

  ResponseVO<PageVO<UserExt>> getClientsByPageAndOwner(int pageNo, int pageSize, String role);

  ResponseVO<List<UserExt>> getAllUsersByRole(String role);

  ResponseVO<UserExt> getUserByUsername(String username);

  ResponseVO<?> updateUserPassword(String username, String oldPassword, String newPassword);

  ResponseVO<?> getUserById(Long id);

  ResponseVO<UserExt> getUserByRoleAndTradeId(String role, Long tradeId);

  ResponseVO<?> uploadSignature(MultipartFile[] imgList, String username);

  ResponseVO<?> getUserSignatures(String username);

  ResponseVO<PageVO<UserExt>> getEmployeePage(int pageNo, int pageSize);
}
