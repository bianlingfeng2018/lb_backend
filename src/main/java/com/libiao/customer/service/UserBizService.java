package com.libiao.customer.service;

import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.util.model.ResponseVO;

public interface UserBizService {

    ResponseVO login(UserExt userExt);

    ResponseVO queryCurrentUser();

    ResponseVO queryUserList(String role);

    ResponseVO queryUserListWithPages(int pageNum, int pageSize);

    ResponseVO logout(); // 登出

    ResponseVO saveUser(UserExt userExt);

    ResponseVO queryRoleTree();

    ResponseVO querySpecificRoleUserList(Long roleId);
}
