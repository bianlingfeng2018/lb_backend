package com.libiao.customer.controller;

import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.client.contract.*;
import com.libiao.customer.service.ContractService;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "客户合同相关接口")
@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation("合同列表")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<ClientContractListVO>> list(@RequestBody ClientContractListReq req){
        PageInfo<ClientContractListVO> list = contractService.list(req);
        return ResponseUtil.getListResponseVO(list.getList(),list.getTotal());
    }

    @ApiOperation("新增合同")
    @PostMapping("add")
    public ResponseEntity<BaseResponseVO> create(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("form") String json){
        AddContractReq req = JSONObject.parseObject(json,AddContractReq.class);
        contractService.addContract(req,file);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation("合同详情")
    @PostMapping("detail")
    public ResponseEntity<ClientContractDetailVO> detail(@RequestBody ContractDetailReq req){
        ClientContractDetailVO detail = contractService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }

    @ApiOperation("编辑合同")
    @PostMapping("modify")
    public ResponseEntity<BaseResponseVO> modify(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("form") String json){
        ModifyContractReq req = JSONObject.parseObject(json,ModifyContractReq.class);
        contractService.modify(req,file);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation("审核合同")
    @PostMapping("review")
    public ResponseEntity<BaseResponseVO> review(@RequestBody ReviewContractReq req){
        contractService.review(req);
        return ResponseUtil.getDefaultResp();
    }

    //下载合同
    @ApiOperation(value = "下载")
    @GetMapping(value = "/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        contractService.download(fileName,response);
    }

}
