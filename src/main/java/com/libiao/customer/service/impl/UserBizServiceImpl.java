package com.libiao.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Sets;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.entity.CurrentUser;
import com.libiao.customer.entity.SessionUser;
import com.libiao.customer.interceptor.SessionInfoEnum;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.ServletUtils;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserBizServiceImpl implements UserBizService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseVO<?> login(User user){
        User currentUser = userRepository.selectByUsernamePassword(user.getUsername(), user.getPassword());
        if(ObjectUtils.isNotEmpty(currentUser)) {
            //验证通过 获取token
            onLogin(currentUser);
            JSONObject loginResult = new JSONObject(true);
            loginResult.put("token", "123");
            loginResult.put("msg", "登录认证成功.");
            return ResponseUtil.success(loginResult);
        }
        return ResponseUtil.error(401, "登录认证失败.");
    }

    @Override
    public ResponseVO<?> queryCurrentUser() {
        return ResponseUtil.success(new CurrentUser(WebUtil.getAccessToken().getUsername(), WebUtil.getAccessToken().getPermission()));
    }

    /**
     * 获取token
     */
    private void onLogin(User user) {
        final HttpSession session = ServletUtils.getSession();

        List<Permission> permissionList = user.getRole().getPermission();
        Set<String> permissionVOList = convertToPermissionVOList(permissionList);
        session.setAttribute(SessionInfoEnum.RULES.getName(),permissionVOList);
        SessionUser sessionUser = BeanCopyUtil.copy(user,SessionUser.class);
        session.setAttribute(SessionInfoEnum.USER.getName(), sessionUser);

    }

    @Override
    public ResponseVO queryUserList(String role) {
        try{
            List<User> users = userRepository.selectAll();
            if(!StringUtils.isEmpty(role)){ // 角色不为空
                users = users.stream().filter(user -> user.getPermission().equals(role)).collect(Collectors.toList());
            }
            return ResponseUtil.success(users);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO queryUserListWithPages(int pageNum, int pageSize) {
        try{
            PageHelper.startPage(pageNum,  pageSize);
            PageHelper.orderBy("id desc");
            List<User> users = userRepository.selectAll();
            PageInfo<User> pageInfo = new PageInfo<User>(users);
            return ResponseUtil.success(pageInfo);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO logout() {
        try{
            ServletUtils.getSession().invalidate();
            JSONObject logoutResult = new JSONObject(true);
            logoutResult.put("username", "username");
            logoutResult.put("msg", "用户退出成功.");
            return ResponseUtil.success(logoutResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO saveUser(User user) {
        try {
            if (StringUtils.isEmpty(user.getPassword())) {
                user.setPassword("123456"); // 初始密码
            }
            user.setGmtCreate(new Date());
            user.setGmtModify(new Date());
            User find = userRepository.selectByUsername(user.getUsername());
            if (Objects.nonNull(find)) {
                return ResponseUtil.error(400, "用户名已存在，新增失败");
            }
            int affectedRows = userRepository.insert(user);
            JSONObject saveUserResult = new JSONObject(true);
            saveUserResult.put("affectedRows", affectedRows);
            saveUserResult.put("userId", user.getId());
            saveUserResult.put("msg", "用户写入成功");
            return ResponseUtil.success(saveUserResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO queryRoleTree() {
        try{
            return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ResponseVO querySpecificRoleUserList(Long roleId) {
        try{
            return null;
        }catch (Exception e){
            return null;
        }
    }

    private Set<String> convertToPermissionVOList(List<Permission> permissionList) {
        Set<String> list = Sets.newHashSet();
        for (Permission permission : permissionList) {
            list.add(permission.getPath());
        }
        return list;
    }
}
