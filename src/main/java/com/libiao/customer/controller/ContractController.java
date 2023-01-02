package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.client.contract.*;
import com.libiao.customer.service.ContractService;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.FileUtil;
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
    @Autowired
    private FileUtil fileUtil;

    @ApiOperation("合同列表")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<ClientContractListVO>> list(@RequestBody ClientContractListReq req){
        PageInfo<ClientContractListVO> list = contractService.list(req);
        return ResponseUtil.getListResponseVO(list.getList(),list.getTotal());
    }

    @ApiOperation("新增合同")
    @PostMapping("add")
    public ResponseEntity<BaseResponseVO> create(@RequestBody AddContractReq req){
        contractService.addContract(req);
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
    public ResponseEntity<BaseResponseVO> modify(@RequestBody ModifyContractReq req){
        contractService.modify(req);
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
    @GetMapping(value = "download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        contractService.download(fileName,response);
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        String fileName = fileUtil.saveContract(file, DateUtils.getDate("yyyyHHmm"));
        return ResponseUtil.getResponseVO(fileName);
    }
}
