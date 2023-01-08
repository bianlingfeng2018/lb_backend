package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestReportMapper;
import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.dal.model.TestReportExample;
import com.libiao.customer.model.report.ReportApproveReq;
import com.libiao.customer.model.report.ReportListReq;
import com.libiao.customer.service.ReportService;
import com.libiao.customer.util.LikeUtil;
import com.libiao.customer.util.exception.LibiaoException;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TestReportMapper testReportMapper;

    @Override
    public PageInfo<TestReport> list(ReportListReq req){
        PageInfo<TestReport> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        TestReportExample example = new TestReportExample();
        final TestReportExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasLength(req.getReportNum())){
            criteria.andReportNumLike(LikeUtil.totalLike(req.getReportNum()));
        }
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        if (StringUtils.hasLength(req.getClient())){
            criteria.andClientLike(LikeUtil.totalLike(req.getClient()));
        }
        if (req.getReportStatus() != null){
            criteria.andReportStatusEqualTo(req.getReportStatus());
        }
        final List<TestReport> testReports = testReportMapper.selectByExample(example);
        page = new PageInfo<>(testReports);
        return page;
    }

    @Override
    public boolean approve(ReportApproveReq req) {
        TestReportExample example = new TestReportExample();
        example.createCriteria().andIdEqualTo(req.getId())
                .andReportNumEqualTo(req.getReportNum());
        List<TestReport> reports = testReportMapper.selectByExample(example);
        if(reports.size()!=1) return false;
        TestReport report = reports.get(0);
        if(report.getReportStatus()!=0){
            throw new LibiaoException("报告单状态不正确");
        }
        report.setReviewer(req.getUser().getUsername());
        report.setReportStatus(report.getReportStatus());
        report.setReason(req.getReason());
        testReportMapper.updateByPrimaryKeySelective(report);
        return true;
    }
}
