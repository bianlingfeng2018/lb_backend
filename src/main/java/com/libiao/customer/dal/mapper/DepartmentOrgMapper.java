package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.DepartmentOrg;
import com.libiao.customer.dal.model.DepartmentOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentOrgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    long countByExample(DepartmentOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int deleteByExample(DepartmentOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int deleteByPrimaryKey(String orgNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int insert(DepartmentOrg row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int insertSelective(DepartmentOrg row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    List<DepartmentOrg> selectByExample(DepartmentOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    DepartmentOrg selectByPrimaryKey(String orgNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int updateByExampleSelective(@Param("row") DepartmentOrg row, @Param("example") DepartmentOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int updateByExample(@Param("row") DepartmentOrg row, @Param("example") DepartmentOrgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int updateByPrimaryKeySelective(DepartmentOrg row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department_org
     *
     * @mbg.generated Sun Dec 25 16:30:12 CST 2022
     */
    int updateByPrimaryKey(DepartmentOrg row);
}