package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.application.*;
import com.libiao.customer.service.ApplicationService;
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

@Api(tags = "申请单相关接口")
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

    @ApiOperation("审核申请单")
    @PostMapping("review")
    public ResponseEntity<BaseResponseVO> review(@RequestBody ReviewApplicationReq req){
        applicationService.review(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation("确认收样")
    @PostMapping("confirm")
    public ResponseEntity<BaseResponseVO> confirm(@RequestBody ApplicationDetailReq req){
        applicationService.confirm(req);
        return ResponseUtil.getDefaultResp();
    }

}
