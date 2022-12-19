package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Role;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.util.model.ResponseVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserCtrl {

    @Autowired
    private UserBizService userBizService;

    /**
     * 展示用户列表, 分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public ResponseVO queryUserList(@RequestParam(name = "role", required = false) String role){
        return userBizService.queryUserList(role);
    }

    @ResponseBody
    @RequestMapping(value = "/queryListWithPages",method = RequestMethod.GET)
    public ResponseVO queryUserListWithPages(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize){
        return userBizService.queryUserListWithPages(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseVO saveUser(@RequestBody User user){
        return userBizService.saveUser(user);
    }

    /**
     * 获取角色树列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryRoleTree", method = RequestMethod.GET)
    public ResponseVO queryRoleTree(){
        return userBizService.queryRoleTree();
    }

    /**
     * 查询特定角色的用户列表
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySpecificRoleUserList", method = RequestMethod.GET)
    public ResponseVO querySpecificRoleUserList(@RequestParam("roleId") Long roleId){
        return userBizService.querySpecificRoleUserList(roleId);
    }

    /**
     *
     * @param user
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUserToRole", method = RequestMethod.POST)
    public ResponseVO addUserToRole(@RequestBody User user, @RequestParam("roleId") Long roleId){
        return addUserToRole(user, roleId);
    }
}
