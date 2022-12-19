package com.libiao.customer.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.PermissionVO;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.entity.CurrentUser;
import com.libiao.customer.repository.RoleRepository;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.util.AccessTokenCacheUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.des.JwtUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserBizServiceImpl implements UserBizService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //redis的key
    private static final String KEY = "libiao88";


    @Override
    public ResponseVO<?> login(User user){
        User currentUser = userRepository.selectByUsernamePassword(user.getUsername(), user.getPassword());
        if(ObjectUtils.isNotEmpty(currentUser)) {
            //验证通过 获取token
            String token = onLogin(currentUser);
            System.out.println(currentUser);
            JSONObject loginResult = new JSONObject(true);
            loginResult.put("token", token);
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
    private String onLogin(User user) {
        List<Permission> permissionList = user.getRole().getPermission();
        List<PermissionVO> permissionVOList = convertToPermissionVOList(permissionList);
        String permission = JSON.toJSONString(permissionVOList);
        String token = JwtUtil.genToken(ImmutableMap.of("username", user.getUsername().toString(),
                "permission", permission,
                "ts", Instant.now().getEpochSecond() + "")); //时间戳 生成token
        stringRedisTemplate.opsForValue().set(AccessTokenCacheUtil.createRedisKey(user.getUsername()), token, 2, TimeUnit.HOURS); //放入缓存
        return token;
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
            String token = WebUtil.getAccessToken().getToken();
            String username = WebUtil.getAccessToken().getUsername();
            stringRedisTemplate.delete(token);
            JSONObject logoutResult = new JSONObject(true);
            logoutResult.put("username", username);
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

    private List<PermissionVO> convertToPermissionVOList(List<Permission> permissionList) {
        ArrayList<PermissionVO> list = Lists.newArrayList();
        for (Permission permission : permissionList) {
            PermissionVO permissionVO = new PermissionVO();
            permissionVO.setPath(permission.getPath());
            list.add(permissionVO);
        }
        return list;
    }
}
