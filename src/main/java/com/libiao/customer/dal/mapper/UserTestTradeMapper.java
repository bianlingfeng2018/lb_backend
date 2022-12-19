package com.libiao.customer.dal.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserTestTradeMapper {

  int deleteAllPermissionByTestTradeIdAndRole(@Param("testTradeId") Long testTradeId,
      @Param("role") String role);

  int insert(@Param(value = "userId") Long userId,
      @Param(value = "testTradeId") Long testTradeId);

}
