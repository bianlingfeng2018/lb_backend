package com.libiao.customer.controller;

import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_CLIENT;

import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.Role;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.model.PageVO;
import com.libiao.customer.service.UserRolePermissionService;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UserRolePermissionCtrl {

  private final UserRolePermissionService userService;

  public UserRolePermissionCtrl(UserRolePermissionService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/api/users-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<UserExt>> getUsersPage(int pageNo, int pageSize) {
    log.info("pageNo = {}, pageSize = {}", pageNo, pageSize);
    return userService.getUsersByPage(pageNo, pageSize);
  }

  @RequestMapping(value = "/api/users", method = RequestMethod.GET)
  public ResponseVO<List<UserExt>> getAllUsers() {
    return userService.getAllUsers();
  }

  @RequestMapping(value = "/api/users-by-role", method = RequestMethod.GET)
  public ResponseVO<List<UserExt>> getAllUsersByRole(String role) {
    return userService.getAllUsersByRole(role);
  }

  @RequestMapping(value = "/api/clients-by-owner", method = RequestMethod.GET)
  public ResponseVO<List<UserExt>> getAllClientsByOwner(String role) {
    return userService.getAllClientsByOwner(role);
  }

  @RequestMapping(value = "/api/clients-page-by-owner", method = RequestMethod.GET)
  public ResponseVO<PageVO<UserExt>> getClientsPageByOwner(int pageNo, int pageSize, String role) {
    return userService.getClientsByPageAndOwner(pageNo, pageSize, ROLE_CLIENT);
  }

  @RequestMapping(value = "/api/employee-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<UserExt>> getEmployeePage(int pageNo, int pageSize) {
    return userService.getEmployeePage(pageNo, pageSize);
  }

  @RequestMapping(value = "/api/roles-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<Role>> getRolesPage(int pageNo, int pageSize) {
    return userService.getRolesByPage(pageNo, pageSize);
  }

  @RequestMapping(value = "/api/routes-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<Role>> getRoutesPage(int pageNo, int pageSize) {
    return userService.getPermissionByPage(pageNo, pageSize);
  }

  @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
  public ResponseVO<List<Role>> getRoles() {
    return userService.getAllRoles();
  }

  @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
  public ResponseVO<Void> updateUser(@PathVariable(value = "id") String id,
      @RequestBody UserExt userExt) {
    return userService.updateUser(userExt);
  }

  @RequestMapping(value = "/api/role/{id}", method = RequestMethod.PUT)
  public ResponseVO<Void> updateRole(@PathVariable(value = "id") String id,
      @RequestBody Role role) {
    return userService.updateRole(role);
  }

  @RequestMapping(value = "/api/permission/{id}", method = RequestMethod.PUT)
  public ResponseVO<Void> updatePermission(@PathVariable(value = "id") String id,
      @RequestBody Permission permission) {
    return userService.updatePermission(permission);
  }

  @RequestMapping(value = "/api/user", method = RequestMethod.POST)
  public ResponseVO<Void> addUser(@RequestBody UserExt userExt) {
    return userService.addUser(userExt);
  }

  @RequestMapping(value = "/api/role", method = RequestMethod.POST)
  public ResponseVO<Void> addRole(@RequestBody Role role) {
    return userService.addRole(role);
  }

  @RequestMapping(value = "/api/permission", method = RequestMethod.POST)
  public ResponseVO<Void> addPermission(@RequestBody Permission permission) {
    return userService.addPermission(permission);
  }

  @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
  public ResponseVO<Void> deleteUser(@PathVariable(value = "id") Long id) {
    return userService.deleteUser(id);
  }

  @RequestMapping(value = "/api/role/{id}", method = RequestMethod.DELETE)
  public ResponseVO<Void> deleteRole(@PathVariable(value = "id") Long id) {
    return userService.deleteRole(id);
  }

  @RequestMapping(value = "/api/permission/{id}", method = RequestMethod.DELETE)
  public ResponseVO<Void> deletePermission(@PathVariable(value = "id") Long id) {
    return userService.deletePermission(id);
  }

  @RequestMapping(value = "/api/user-by-username", method = RequestMethod.GET)
  public ResponseVO<UserExt> getUserByUsername(@RequestParam(value = "username") String username) {
    return userService.getUserByUsername(username);
  }

  @RequestMapping(value = "/api/user-by-id", method = RequestMethod.GET)
  public ResponseVO<?> getUserById(@RequestParam(value = "id") Long id) {
    return userService.getUserById(id);
  }

  @RequestMapping(value = "/api/user-by-role-and-trade-id", method = RequestMethod.GET)
  public ResponseVO<UserExt> getUserByRoleAndTradeId(
      @RequestParam(value = "tradeId") Long tradeId,
      @RequestParam(value = "role") String role
  ) {
    return userService.getUserByRoleAndTradeId(role, tradeId);
  }

  @RequestMapping(value = "/api/updateUserPassword", method = RequestMethod.POST)
  public ResponseVO<?> updateUserPassword(
      @RequestParam(value = "username") String username,
      @RequestParam(value = "oldPassword") String oldPassword,
      @RequestParam(value = "newPassword") String newPassword) {
    return userService.updateUserPassword(username, oldPassword, newPassword);
  }

  /**
   * 上传签名
   * @param username 用户名
   * @param imgList 签名图片，可以为空
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/api/upload-signature", method = RequestMethod.POST)
  public ResponseVO<?> uploadSignature(
      @RequestParam(value = "username") String username,
      MultipartFile[] imgList) {
    return userService.uploadSignature(imgList, username);
  }

  @ResponseBody
  @RequestMapping(value = "/api/user-signature", method = RequestMethod.GET)
  public ResponseVO<?> getUserSignatures(@RequestParam(value = "username") String username){
    log.info(username);
    return userService.getUserSignatures(username);
  }
}
