package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.dal.model.BasicCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicCountryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    long countByExample(BasicCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int deleteByExample(BasicCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int insert(BasicCountry row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int insertSelective(BasicCountry row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    List<BasicCountry> selectByExample(BasicCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    BasicCountry selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int updateByExampleSelective(@Param("row") BasicCountry row, @Param("example") BasicCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int updateByExample(@Param("row") BasicCountry row, @Param("example") BasicCountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int updateByPrimaryKeySelective(BasicCountry row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_country
     *
     * @mbg.generated Thu Dec 29 09:59:07 CST 2022
     */
    int updateByPrimaryKey(BasicCountry row);
}