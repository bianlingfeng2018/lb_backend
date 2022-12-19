package com.libiao.customer.repository;

public interface UserTestTradeRepository {

  int insert(Long userId, Long testTradeId);

  int deleteAllPermissionByTestTradeIdAndRole(Long testTradeId, String role);

}
