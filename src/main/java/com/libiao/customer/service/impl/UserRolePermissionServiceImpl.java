package com.libiao.customer.service.impl;

import static com.libiao.customer.util.SystemConstant.getUserSignatureDir;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_ADMIN;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_CLIENT;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_CUSTOM_SERVICE;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_SALESMAN;
import static com.libiao.customer.util.file.FileUploadUtil.recurseDelFile;
import static com.libiao.customer.util.file.FileUploadUtil.uploadToFileDir;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.Role;
import com.libiao.customer.dal.model.RolePermission;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.repository.PermissionRepository;
import com.libiao.customer.repository.RolePermissionRepository;
import com.libiao.customer.repository.RoleRepository;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.repository.UserTestTradeRepository;
import com.libiao.customer.service.UserRolePermissionService;
import com.libiao.customer.util.FileVO;
import com.libiao.customer.util.PageUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserRolePermissionServiceImpl implements UserRolePermissionService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final RolePermissionRepository rolePermissionRepository;

  private final UserTestTradeRepository userTestTradeRepository;

  private final PermissionRepository permissionRepository;

  public UserRolePermissionServiceImpl(UserRepository userRepository,
      RoleRepository roleRepository, RolePermissionRepository rolePermissionRepository,
      UserTestTradeRepository userTestTradeRepository, PermissionRepository permissionRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.rolePermissionRepository = rolePermissionRepository;
    this.userTestTradeRepository = userTestTradeRepository;
    this.permissionRepository = permissionRepository;
  }

  @Override
  public ResponseVO<Void> deleteUser(Long userId) {
    try {
      userRepository.deleteByPrimaryKey(userId);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> deletePermission(Long permissionId) {
    try {
      permissionRepository.deleteByPrimaryKey(permissionId);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> deleteRole(Long roleId) {
    try {
      rolePermissionRepository.deleteAllPermissionByPrimaryKey(roleId);
      roleRepository.deleteByPrimaryKey(roleId);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Transactional
  @Override
  public ResponseVO<Void> addRole(Role role) {
    try {
      roleRepository.insert(role);
      List<Permission> permission = role.getPermission();
      for (Permission per : permission) {
        Permission perByPath = permissionRepository.findByPath(per.getPath());
        rolePermissionRepository.insert(role.getId(), perByPath.getId());
      }
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> addUser(UserExt userExt) {
    try {
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      userExt.setCreatedBy(loginUserExt.getId());
      userExt.setGmtCreate(new Date());
      userExt.setGmtModify(new Date());
      userExt.setPermission("");
      userRepository.insert(userExt);
      JSONObject result = new JSONObject();
      result.put("msg", "新增成功");
      return ResponseUtil.success(result);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> addPermission(Permission permission) {
    try {
      permissionRepository.insert(permission);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<UserExt>> getUsersByPage(int pageNo, int pageSize) {
    try {
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<UserExt> userExts = userRepository.selectAllWithRole();
      PageInfo<UserExt> page = new PageInfo<>(userExts);
      page.setList(userExts);
      PageVO<UserExt> pageVO = PageUtil.createPageVO(pageNo, pageSize, page.getPages(),
          page.getTotal(), page.getList());
      return ResponseUtil.success(pageVO);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<List<UserExt>> getAllUsers() {
    try {
      List<UserExt> list = userRepository.selectAll();
      return ResponseUtil.success(list);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<Role>> getRolesByPage(int pageNo, int pageSize) {
    try {
      Page<Object> page = PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Role> roles = roleRepository.selectAll();
      for (Role role : roles) {
        List<Permission> permissions = Lists.newArrayList();
        List<RolePermission> rolePermissionList = rolePermissionRepository.selectByRoleId(
            role.getId());
        for (RolePermission rolePermission : rolePermissionList) {
          long permissionId = rolePermission.getPermissionId();
          Permission p = permissionRepository.selectByPrimaryKey(permissionId);
          permissions.add(p);
        }
        role.setPermission(permissions);
      }
      PageInfo<Role> pageInfo = new PageInfo<>(roles);
      PageVO<Role> pageVO = PageUtil.createPageVO(pageNo, pageSize, pageInfo.getPages(),
          page.getTotal(), pageInfo.getList());
      return ResponseUtil.success(pageVO);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> updateUser(UserExt userExt) {
    try {
      UserExt find = userRepository.selectByPrimaryKey(userExt.getId());
      if (Objects.isNull(find)) {
        return ResponseUtil.error(404, "用户不存在，修改失败");
      }
      userExt.setGmtModify(new Date());
      userRepository.updateByPrimaryKey(userExt);
      JSONObject result = new JSONObject();
      result.put("msg", "更新成功");
      return ResponseUtil.success(result);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> updatePermission(Permission permission) {
    try {
      permissionRepository.updateByPrimaryKey(permission);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Transactional
  @Override
  public ResponseVO<Void> updateRole(Role role) {
    // service需要做事务，当产生异常时自动回滚
//    try {
      roleRepository.updateByPrimaryKey(role);
      rolePermissionRepository.deleteAllPermissionByPrimaryKey(role.getId());
      List<Permission> permission = role.getPermission();
      for (Permission per : permission) {
        String path = per.getPath();
        Permission perByPath = permissionRepository.findByPath(path);
        if (Objects.isNull(perByPath)) {
          return ResponseUtil.error(404, "数据权限不存在！");
        }
        rolePermissionRepository.insert(role.getId(), perByPath.getId());
      }
      return ResponseUtil.success();
//    } catch (Exception e) {
//      e.printStackTrace();
//      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
//    }
  }

  @Override
  public ResponseVO<List<Role>> getAllRoles() {
    try {
      List<Role> list = roleRepository.selectAll();
      return ResponseUtil.success(list);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<Role>> getPermissionByPage(int pageNo, int pageSize) {
    try {
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Permission> permissions = permissionRepository.selectAll();
      PageInfo<Permission> page = new PageInfo<>(permissions);
      PageVO<Permission> pageVO = PageUtil.createPageVO(pageNo, pageSize, page.getPages(),
          page.getTotal(), page.getList());
      return ResponseUtil.success(pageVO);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<List<UserExt>> getAllClientsByOwner(String role) {
    try {
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      String loginRole = loginUserExt.getRole().getName();
      String LoginUsername = loginUserExt.getUsername();
      List<UserExt> userExts = Lists.newArrayList();
      switch (loginRole) {
        case ROLE_SALESMAN:
          userExts = userRepository.selectAllWithRoleByRoleAndCreatedBy(role, loginUserExt.getId());
          break;
        case ROLE_CUSTOM_SERVICE:
          userExts = userRepository.selectAllWithRoleByRoleInSameTestTrade(role, LoginUsername);
          break;
        case ROLE_ADMIN:
          userExts = userRepository.selectAllWithRoleByRole(role);
        default:
          break;
      }
      return ResponseUtil.success(userExts);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<UserExt>> getClientsByPageAndOwner(int pageNo, int pageSize, String role) {
    try {
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      String loginRole = loginUserExt.getRole().getName();
      String LoginUsername = loginUserExt.getUsername();
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<UserExt> userExts = Lists.newArrayList();
      switch (loginRole) {
        case ROLE_SALESMAN:
          userExts = userRepository.selectAllWithRoleByRoleAndCreatedBy(role, loginUserExt.getId());
          break;
        case ROLE_CUSTOM_SERVICE:
          userExts = userRepository.selectAllWithRoleByRoleInSameTestTrade(role, LoginUsername);
          break;
        case ROLE_ADMIN:
          userExts = userRepository.selectAllWithRoleByRole(role);
          break;
        default:
          break;
      }
      PageInfo<UserExt> page = new PageInfo<>(userExts);
      PageVO<UserExt> pageVO = PageUtil.createPageVO(pageNo, pageSize, page.getPages(),
          page.getTotal(), page.getList());
      return ResponseUtil.success(pageVO);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<List<UserExt>> getAllUsersByRole(String role) {
    try {
      List<UserExt> userExts = userRepository.selectAllWithRoleByRole(role);
      return ResponseUtil.success(userExts);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<UserExt> getUserByUsername(String username) {
    try {
      UserExt userExt = userRepository.selectByUsername(username);
      return ResponseUtil.success(userExt);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> updateUserPassword(String username, String oldPassword, String newPassword) {
    try {
      UserExt userExt = userRepository.selectByUsername(username);
      String password = userExt.getPassword();
      if (!Objects.equals(oldPassword, password)) {
        return ResponseUtil.error(400, "密码错误");
      }
      userExt.setPassword(newPassword);
      userRepository.updateByPrimaryKey(userExt);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getUserById(Long id) {
    try {
      UserExt userExt = userRepository.selectByPrimaryKeyWithRole(id);
      JSONObject jsonObject = (JSONObject) JSONObject.toJSON(userExt);
      jsonObject.put("flexObj", JSONObject.parse(userExt.getFlexObj()));
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<UserExt> getUserByRoleAndTradeId(String role, Long tradeId) {
    try {
      UserExt userExt = userRepository.selectByRoleAndTestTrade(role, tradeId);
      if (Objects.isNull(userExt)) {
        return ResponseUtil.error(404, "未找到用户信息");
      }
      return ResponseUtil.success(userExt);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> uploadSignature(MultipartFile[] imgList, String username) {
    try {
      UserExt userExt = userRepository.selectByUsername(username);
      //上传附件
      if (!ArrayUtils.isEmpty(imgList)) {
        String dir1 = getUserSignatureDir(String.valueOf(userExt.getId()));
        recurseDelFile(dir1);
        uploadToFileDir(dir1, imgList);
      }
      JSONObject downloadResult = new JSONObject(true);
      downloadResult.put("msg", "上传电子签名成功");
      return ResponseUtil.success(downloadResult);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getUserSignatures(String username) {
    try {
      UserExt userExt = userRepository.selectByUsername(username);
      String path = getUserSignatureDir(String.valueOf(userExt.getId()));
      File file = new File(path);
      File[] files = file.listFiles();
      if (files == null || files.length == 0) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "未找到电子签名文件");
        return ResponseUtil.success(jsonObject);
      }
      ArrayList<FileVO> fileVOs = Lists.newArrayList();
      for (File f : files) {
        FileVO fileVO = new FileVO();
        fileVO.setName(f.getName());
        fileVO.setPath(path);
        fileVOs.add(fileVO);
      }
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("data", fileVOs);
      jsonObject.put("msg", "获取电子签名成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<UserExt>> getEmployeePage(int pageNo, int pageSize) {
    try {
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<UserExt> userExts = userRepository.selectAllWithRoleByNotRole(ROLE_CLIENT);
      PageInfo<UserExt> page = new PageInfo<>(userExts);
      page.setList(userExts);
      PageVO<UserExt> pageVO = PageUtil.createPageVO(pageNo, pageSize, page.getPages(),
          page.getTotal(), page.getList());
      return ResponseUtil.success(pageVO);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }


}
