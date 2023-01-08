package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.report.ReportApproveBatchReq;
import com.libiao.customer.model.report.ReportApproveReq;
import com.libiao.customer.model.report.ReportListReq;
import com.libiao.customer.model.report.ReportListVO;
import com.libiao.customer.service.ReportService;
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

@Api(tags = "检测报告单接口")
@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("list")
    @ApiOperation("检测报告单列表")
    public ResponseEntity<ListResponseVO<ReportListVO>> list(@RequestBody ReportListReq req){
        List<ReportListVO> voList = new ArrayList<>();
        final PageInfo<TestReport> list = reportService.list(req);
        list.getList().forEach(report->voList.add(BeanCopyUtil.copy(report,ReportListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @PostMapping("approve")
    @ApiOperation("检测报告单审核")
    public ResponseEntity<BaseResponseVO> approve(@RequestBody ReportApproveReq req){
        reportService.approve(req);
        return ResponseUtil.getDefaultResp();
    }

    @PostMapping("approveBatch")
    @ApiOperation("检测报告单审核")
    public ResponseEntity<BaseResponseVO> approveBatch(@RequestBody ReportApproveBatchReq req){
       req.getReqList().forEach(reportApproveReq -> {
           reportApproveReq.setUser(req.getUser());
           reportService.approve(reportApproveReq);
       });
        return ResponseUtil.getDefaultResp();
    }
}
