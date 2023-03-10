package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicHscode;
import com.libiao.customer.dal.model.BasicHscodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicHscodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    long countByExample(BasicHscodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int deleteByExample(BasicHscodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int insert(BasicHscode row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int insertSelective(BasicHscode row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    List<BasicHscode> selectByExample(BasicHscodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    BasicHscode selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int updateByExampleSelective(@Param("row") BasicHscode row, @Param("example") BasicHscodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int updateByExample(@Param("row") BasicHscode row, @Param("example") BasicHscodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int updateByPrimaryKeySelective(BasicHscode row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_hscode
     *
     * @mbg.generated Fri Jan 06 16:45:34 CST 2023
     */
    int updateByPrimaryKey(BasicHscode row);
}