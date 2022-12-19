package com.libiao.customer.service;

import com.libiao.customer.dal.model.User;
import com.libiao.customer.util.model.ResponseVO;

public interface UserBizService {

    ResponseVO login(User user);

    ResponseVO queryCurrentUser();

    ResponseVO queryUserList(String role);

    ResponseVO queryUserListWithPages(int pageNum, int pageSize);

    ResponseVO logout(); // 登出

    ResponseVO saveUser(User user);

    ResponseVO queryRoleTree();

    ResponseVO querySpecificRoleUserList(Long roleId);
}
