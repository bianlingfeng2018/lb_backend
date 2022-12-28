package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.dal.model.TestQuotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestQuotationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    long countByExample(TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int deleteByExample(TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int insert(TestQuotation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int insertSelective(TestQuotation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    List<TestQuotation> selectByExampleWithBLOBs(TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    List<TestQuotation> selectByExample(TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    TestQuotation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByExampleSelective(@Param("row") TestQuotation row, @Param("example") TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("row") TestQuotation row, @Param("example") TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByExample(@Param("row") TestQuotation row, @Param("example") TestQuotationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByPrimaryKeySelective(TestQuotation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(TestQuotation row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_quotation
     *
     * @mbg.generated Wed Dec 28 10:55:30 CST 2022
     */
    int updateByPrimaryKey(TestQuotation row);
}