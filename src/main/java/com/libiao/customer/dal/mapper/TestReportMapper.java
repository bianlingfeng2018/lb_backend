package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.dal.model.TestReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestReportMapper {
    long countByExample(TestReportExample example);

    int deleteByExample(TestReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestReport row);

    int insertSelective(TestReport row);

    List<TestReport> selectByExample(TestReportExample example);

    TestReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestReport row, @Param("example") TestReportExample example);

    int updateByExample(@Param("row") TestReport row, @Param("example") TestReportExample example);

    int updateByPrimaryKeySelective(TestReport row);

    int updateByPrimaryKey(TestReport row);
}