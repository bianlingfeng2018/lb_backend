package com.libiao.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.beust.jcommander.internal.Sets;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Permission;
import com.libiao.customer.dal.model.PermissionVO;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.entity.CurrentUser;
import com.libiao.customer.entity.SessionUser;
import com.libiao.customer.interceptor.SessionInfoEnum;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.ServletUtils;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserBizServiceImpl implements UserBizService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public ResponseVO<?> login(UserExt userExt){
        UserExt currentUserExt = userRepository.selectByUsernamePassword(userExt.getUsername(), userExt.getPassword());
        if(ObjectUtils.isNotEmpty(currentUserExt)) {
            //验证通过 获取token
            onLogin(currentUserExt);
            JSONObject loginResult = new JSONObject(true);
            loginResult.put("token", "123");
            loginResult.put("msg", "登录认证成功.");
            return ResponseUtil.success(loginResult);
        }
        return ResponseUtil.error(401, "登录认证失败.");
    }

    @Override
    public ResponseVO<?> queryCurrentUser() {
        final HttpSession session = ServletUtils.getSession();
        final SessionUser user = (SessionUser) session.getAttribute(SessionInfoEnum.USER.getName());
        Set<String> roleSet = (Set<String>) session.getAttribute(SessionInfoEnum.RULES.getName());
        List<PermissionVO> list = new ArrayList<>();
        roleSet.forEach(rule->{
            final PermissionVO permissionVO = new PermissionVO();
            permissionVO.setPath(rule);
            list.add(permissionVO);
        });
        return ResponseUtil.success(new CurrentUser(user.getUsername(), JSON.toJSONString(list)));
    }

    /**
     * 获取token
     */
    private void onLogin(UserExt userExt) {
        final HttpSession session = ServletUtils.getSession();

        List<Permission> permissionList = userExt.getRole().getPermission();
        Set<String> permissionVOList = convertToPermissionVOList(permissionList);
        session.setAttribute(SessionInfoEnum.RULES.getName(),permissionVOList);
        SessionUser sessionUser = BeanCopyUtil.copy(userExt,SessionUser.class);
        sessionUser.setDiscount(userExt.getRole().getDiscount());
        session.setAttribute(SessionInfoEnum.USER.getName(), sessionUser);
        log.info("保存的sessionId为{}",session.getId());
        String key = "LOGIN_SESSION:" + sessionUser.getId();
        //唯一登录校验
        redisTemplate.opsForValue().set(key,session.getId());
    }

    @Override
    public ResponseVO queryUserList(String role) {
        try{
            List<UserExt> userExts = userRepository.selectAll();
            if(!StringUtils.isEmpty(role)){ // 角色不为空
                userExts = userExts.stream().filter(user -> user.getPermission().equals(role)).collect(Collectors.toList());
            }
            return ResponseUtil.success(userExts);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO queryUserListWithPages(int pageNum, int pageSize) {
        try{
            PageHelper.startPage(pageNum,  pageSize);
            PageHelper.orderBy("id desc");
            List<UserExt> userExts = userRepository.selectAll();
            PageInfo<UserExt> pageInfo = new PageInfo<UserExt>(userExts);
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
    public ResponseVO saveUser(UserExt userExt) {
        try {
            if (StringUtils.isEmpty(userExt.getPassword())) {
                userExt.setPassword("123456"); // 初始密码
            }
            userExt.setGmtCreate(new Date());
            userExt.setGmtModify(new Date());
            UserExt find = userRepository.selectByUsername(userExt.getUsername());
            if (Objects.nonNull(find)) {
                return ResponseUtil.error(400, "用户名已存在，新增失败");
            }
            int affectedRows = userRepository.insert(userExt);
            JSONObject saveUserResult = new JSONObject(true);
            saveUserResult.put("affectedRows", affectedRows);
            saveUserResult.put("userId", userExt.getId());
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
