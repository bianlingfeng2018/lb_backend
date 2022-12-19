package com.libiao.customer.util;

import com.alibaba.fastjson.JSONObject;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.PermissionVO;
import java.util.List;
import java.util.Objects;

/**
 * @author Lingfeng
 */
public class UserRolePermissionUtil {


  /**
   * 判断是否为admin
   *
   * @param permission 用户的权限列表
   * @return
   */
  public static boolean isAdmin(String permission) {
    List<PermissionVO> list = JSONObject.parseArray(permission, PermissionVO.class);
    return list.stream()
        .anyMatch(per -> Objects.equals(per.getPath(), "/am/data"));
  }


}
