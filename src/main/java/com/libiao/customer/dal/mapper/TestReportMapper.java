package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestReport;
import com.libiao.customer.dal.model.TestReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    long countByExample(TestReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int deleteByExample(TestReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int insert(TestReport row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int insertSelective(TestReport row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    List<TestReport> selectByExample(TestReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    TestReport selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int updateByExampleSelective(@Param("row") TestReport row, @Param("example") TestReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int updateByExample(@Param("row") TestReport row, @Param("example") TestReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int updateByPrimaryKeySelective(TestReport row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_report
     *
     * @mbg.generated Sun Jan 08 10:44:18 CST 2023
     */
    int updateByPrimaryKey(TestReport row);
}