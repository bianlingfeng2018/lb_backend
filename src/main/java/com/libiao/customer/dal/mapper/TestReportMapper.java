package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestReport;
import java.util.List;

public interface TestReportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestReport row);

    TestReport selectByPrimaryKey(Long id);

    List<TestReport> selectAll();

    int updateByPrimaryKey(TestReport row);

    List<TestReport> queryTestReportByTestTradeId(Long testTradeId);

    List<TestReport> selectAllByOwner(String userName);

    TestReport selectTestReportByReportNum(String reportNum);
}