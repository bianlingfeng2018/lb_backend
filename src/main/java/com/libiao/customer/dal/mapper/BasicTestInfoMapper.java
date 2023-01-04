package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicTestInfo;
import com.libiao.customer.dal.model.BasicTestInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicTestInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    long countByExample(BasicTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int deleteByExample(BasicTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int insert(BasicTestInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int insertSelective(BasicTestInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    List<BasicTestInfo> selectByExample(BasicTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    BasicTestInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int updateByExampleSelective(@Param("row") BasicTestInfo row, @Param("example") BasicTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int updateByExample(@Param("row") BasicTestInfo row, @Param("example") BasicTestInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int updateByPrimaryKeySelective(BasicTestInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_test_info
     *
     * @mbg.generated Mon Jan 02 16:00:25 CST 2023
     */
    int updateByPrimaryKey(BasicTestInfo row);
}