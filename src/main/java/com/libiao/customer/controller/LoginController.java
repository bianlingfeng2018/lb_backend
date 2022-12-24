package com.libiao.customer.controller;

import com.libiao.customer.dal.model.User;
import com.libiao.customer.entity.RegisterResult;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.ServletUtils;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    UserBizService userBizService;

    /**
     * 用户登录
     * @return
     */
    @AccessController
    @ResponseBody
    @RequestMapping(value = "/login/account", method = RequestMethod.POST)
    public ResponseVO login(@RequestBody User user){
        log.info(">>>>>>>>> 用户登录接口 param：{}", user.toString());
        return userBizService.login(user);
    }

    /**
     * 用户登出
     * @return
     */
    @AccessController
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseVO logout(){
        return userBizService.logout();
    }

    @AccessController
    @ResponseBody
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseVO currentUser() {
        return userBizService.queryCurrentUser();
    }

    @AccessController
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResult register(){
        return null;
    }
}
