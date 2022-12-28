package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.quotation.*;
import com.libiao.customer.service.QuotationService;
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

@RestController
@RequestMapping("quotation")
@Api(tags = "报价单接口")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("list")
    @ApiOperation("报价单列表")
    public ResponseEntity<ListResponseVO<QuotationListVO>> list(@RequestBody QuotationListReq req){
        final PageInfo<TestQuotation> list = quotationService.list(req);
        List<QuotationListVO> voList = new ArrayList<>();
        list.getList().forEach(db->voList.add(BeanCopyUtil.copy(db,QuotationListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @AccessController
    @ApiOperation("获取费率")
    @PostMapping("getRate")
    public ResponseEntity<String> getRate(){
        final String rate = quotationService.getRate();
        return ResponseUtil.getResponseVO(rate);
    }

    //新增报价单
    @ApiOperation("新增报价单")
    @PostMapping("create")
    public ResponseEntity<BaseResponseVO> create(@RequestBody CreateQuotationReq req){
        quotationService.create(req);
        return ResponseUtil.getDefaultResp();
    }

    //编辑报价单
    @ApiOperation("修改报价单")
    @PostMapping("modify")
    public ResponseEntity<BaseResponseVO> modify(@RequestBody ModifyQuotationReq req){
        quotationService.modify(req);
        return ResponseUtil.getDefaultResp();
    }

    //审核报价单
    //判断下，是否新增一条待核销记录
    @ApiOperation("审核报价单")
    @PostMapping("examine")
    public ResponseEntity<BaseResponseVO> examine(@RequestBody ExamineQuotationReq req){
        quotationService.examine(req);
        return ResponseUtil.getDefaultResp();
    }

    //加测报价单
    @ApiOperation("加测/复测报价单")
    @PostMapping("additional")
    public ResponseEntity<BaseResponseVO> additional(@RequestBody AddQuotationReq req){
        quotationService.addQuot(req);
        return ResponseUtil.getDefaultResp();
    }

    //报价单详情
    @ApiOperation("详情")
    @PostMapping("detail")
    public ResponseEntity<QuotationDetailVO> detail(@RequestBody QuotationDetailReq req){
        final QuotationDetailVO detail = quotationService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }


}
