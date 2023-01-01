package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Client;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.client.ClientSimpleReq;
import com.libiao.customer.model.client.ClientSimpleVO;
import com.libiao.customer.service.CustomerService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "客户相关")
@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("根据客户姓名获取列表")
    @PostMapping("search/name")
    @AccessController
    public ResponseEntity<ListResponseVO<ClientSimpleVO>> getClientByName(@RequestBody ClientSimpleReq req){
        List<ClientSimpleVO> voList = new ArrayList<>();
        List<Client> clientByName = customerService.getClientByName(req);
        clientByName.forEach(client -> voList.add(BeanCopyUtil.copy(client,ClientSimpleVO.class)));
        return ResponseUtil.getListResponseVO(voList,voList.size());
    }
}
