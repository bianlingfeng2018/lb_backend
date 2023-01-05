package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.CheckCompany;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.BaseSessionReq;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.org.*;
import com.libiao.customer.service.OrgService;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组织架构管理
 */
@Api(tags = "组织架构接口")
@RestController
@RequestMapping("org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @PostMapping("create")
    @ApiOperation("新增组织")
    public ResponseEntity<BaseResponseVO> createOrg(@RequestBody CreateOrgReq req){
        orgService.createOrg(req);
        return ResponseUtil.getDefaultResp();
    }

    @PostMapping("modify")
    @ApiOperation("编辑组织")
    public ResponseEntity<BaseResponseVO> modify(@RequestBody ModifyOrgReq req){
        orgService.modify(req);
        return ResponseUtil.getDefaultResp();
    }

    @PostMapping("list")
    @ApiOperation("下属组织列表")
    public ResponseEntity<ListResponseVO<OrgListVO>> list(@RequestBody SubOrgListReq req){
        final PageInfo<OrgListVO> list = orgService.list(req);
        return ResponseUtil.getListResponseVO(list.getList(),list.getTotal());
    }

    @PostMapping("tree")
    @ApiOperation("获取组织机构树")
    public ResponseEntity<OrgComboVO> tree(@RequestBody BaseSessionReq req){
        final OrgComboVO orgComboVO = orgService.selectAll();
        return ResponseUtil.getResponseVO(orgComboVO);
    }

    @PostMapping("allCompany")
    @ApiOperation("获取所有公司信息")
    public ResponseEntity<List<CheckCompany>> getAllCheckCompany(@RequestBody BaseSessionReq req){
        return orgService.getAllCheckCompany();
    }




}
