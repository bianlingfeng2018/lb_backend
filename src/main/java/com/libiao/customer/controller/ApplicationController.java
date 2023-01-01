package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.application.*;
import com.libiao.customer.service.ApplicationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("application")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @ApiOperation("获取申请单列表")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<ApplicationListVO>> list(@RequestBody ApplicationListReq req){
        List<ApplicationListVO> voList = new ArrayList<>();
        PageInfo<TestApplicationForm> list = applicationService.list(req);
        list.getList().forEach(app->voList.add(BeanCopyUtil.copy(app,ApplicationListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @ApiOperation("新增申请单")
    @PostMapping("create")
    public ResponseEntity<BaseResponseVO> create(@RequestBody AddApplicationReq req){
        applicationService.createApplication(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation("申请单详情")
    @PostMapping("detail")
    public ResponseEntity<ApplicationDetailVO> detail(@RequestBody ApplicationDetailReq req){
        ApplicationDetailVO detail = applicationService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }

    @ApiOperation("修改申请单")
    @PostMapping("modify")
    public ResponseEntity<BaseResponseVO> modify(@RequestBody ModifyApplicationReq req){
        applicationService.modify(req);
        return ResponseUtil.getDefaultResp();
    }

}
