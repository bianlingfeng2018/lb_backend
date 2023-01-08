package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.model.report.ReportApproveReq;
import com.libiao.customer.model.report.ReportListReq;

public interface ReportService {

    PageInfo<TestReport> list(ReportListReq req);
    boolean approve(ReportApproveReq req);

}
