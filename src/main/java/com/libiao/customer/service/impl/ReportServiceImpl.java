package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.report.*;
import com.libiao.customer.service.ReportService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.LikeUtil;
import com.libiao.customer.util.exception.LibiaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TestReportMapper testReportMapper;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private TestApplicationSampleMapper testApplicationSampleMapper;
    @Autowired
    private TestOriRecordMapper testOriRecordMapper;
    @Autowired
    private TestRecordSubItemMapper subItemMapper;

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
        TestReport update = new TestReport();
        update.setId(report.getId());
        update.setReviewer(req.getUser().getUsername());
        update.setReportStatus(req.getReportStatus());
        update.setReason(req.getReason());
        testReportMapper.updateByPrimaryKeySelective(update);

        return true;
    }

    @Override
    public ReportDetailVO detail(ReportDetailReq req){
        ReportDetailVO vo = new ReportDetailVO();
        TestReport testReport = testReportMapper.selectByPrimaryKey(req.getTestReportId());
        //找到对应的申请单的样品信息
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(testReport.getApplicationNum());
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);

        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationNumEqualTo(testReport.getApplicationNum());
        List<TestApplicationSample> testApplicationSamples = testApplicationSampleMapper.selectByExample(sampleExample);

        //找到所有的原始报告单结果
        TestOriRecordExample oriExample = new TestOriRecordExample();
        oriExample.createCriteria().andApplicationNumEqualTo(testReport.getApplicationNum());
        List<TestOriRecord> testOriRecords = testOriRecordMapper.selectByExample(oriExample);
        //转对象
        BeanCopyUtil.copy(testReport,vo);
        //
        ReportSampleVO sampleVO = new ReportSampleVO();
        BeanCopyUtil.copy(testApplicationForm,sampleVO);
        vo.setSample(sampleVO);

        List<ReportSampleDescVO> descList = new ArrayList<>();
        testApplicationSamples.forEach(desc->descList.add(BeanCopyUtil.copy(desc,ReportSampleDescVO.class)));
        vo.setDescList(descList);

        List<TestResultVO> results = new ArrayList<>();
        for (TestOriRecord testOriRecord : testOriRecords) {
            TestResultVO result = BeanCopyUtil.copy(testOriRecord, TestResultVO.class);
            TestRecordSubItemExample subExample = new TestRecordSubItemExample();
            subExample.createCriteria().andOriRecordIdEqualTo(testOriRecord.getId());
            List<TestRecordSubItem> testRecordSubItems = subItemMapper.selectByExample(subExample);
            List<SubTestResultVO> subList = new ArrayList<>();
            if (!CollectionUtils.isEmpty(testRecordSubItems)){
                testRecordSubItems.forEach(sub->subList.add(BeanCopyUtil.copy(sub,SubTestResultVO.class)));
            }
            result.setSubList(subList);
            results.add(result);
        }
        vo.setTestResult(results);
        return vo;
    }

}
