package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestReportMapper;
import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.dal.model.TestReportExample;
import com.libiao.customer.model.report.ReportListReq;
import com.libiao.customer.service.ReportService;
import com.libiao.customer.util.LikeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

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
}
