package com.libiao.customer.controller;

import com.libiao.customer.dal.model.User;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.user.SimpleUserInfo;
import com.libiao.customer.service.UserService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户相关接口")
@RequestMapping("api/user")
@RestController
public class UserController {

    private static final long ROLE_SERVICE = 2;

    @Autowired
    private UserService userService;

    @PostMapping("service/list")
    @ApiOperation("获取客服列表")
    @AccessController
    public ResponseEntity<ListResponseVO<SimpleUserInfo>> getService(){
        final List<User> userByRoleId = userService.getUserByRoleId(ROLE_SERVICE);
        //转码
        List<SimpleUserInfo> list = new ArrayList<>(userByRoleId.size());
        userByRoleId.forEach(u->list.add(BeanCopyUtil.copy(u,SimpleUserInfo.class)));
        return ResponseUtil.getListResponseVO(list,list.size());
    }
}
